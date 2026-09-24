package net.creepyforest.coregregation.common.world_preset;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

import static net.creepyforest.coregregation.CoreGregation.LOGGER;

public class TerrainConfigLogic {

    //THE MOD SWAPPING IS VIBECODED PLS DON'T CUT MY HEAD OFF
    //im not very good at java and I had to compromise with this AI im sorry, I will replace it when I learn more
    //the rest is made by me tho so hooray

    public static boolean isTerraTonicActive;
    public static boolean isEpicTerrainandWWEEActive;
    public static boolean isLithoSphereAndStillLifeActive;
    public static boolean isVanillaTerrainActive;

    private static final Map<TerrainPresets, List<String>> PREFIXES = Map.of(
            TerrainPresets.TERRATONIC, List.of("tectonic", "terralith"),
            TerrainPresets.EPIC_TERRAIN_WWEE, List.of("epicterrain", "wwee"),
            TerrainPresets.LITHOSPHERE_STILL_LIFE, List.of("lithosphere", "stilllife"),
            TerrainPresets.VANILLA, List.of()
    );

    //also this List<Path[]> thing is also ai, dw it just shows the log what mods were swapped

    public static void terraTonicActive() throws Exception {
        List<Path[]> moves = buildMovesFor(TerrainPresets.TERRATONIC);
        logMoves(moves, TerrainPresets.TERRATONIC);
        scheduleSwap(moves);

        isTerraTonicActive = true;
        isEpicTerrainandWWEEActive = false;
        isLithoSphereAndStillLifeActive = false;
        isVanillaTerrainActive = false;
        saveState("TERRATONIC");
    }

    public static void epicTerrainAndWWEEActive() throws Exception {
        List<Path[]> moves = buildMovesFor(TerrainPresets.EPIC_TERRAIN_WWEE);
        logMoves(moves, TerrainPresets.EPIC_TERRAIN_WWEE);
        scheduleSwap(moves);

        isTerraTonicActive = false;
        isEpicTerrainandWWEEActive = true;
        isLithoSphereAndStillLifeActive = false;
        isVanillaTerrainActive = false;
        saveState("EPIC_TERRAIN+WWEE");
    }

    public static void lithoSphereAndStillLifeActive() throws Exception {
        List<Path[]> moves = buildMovesFor(TerrainPresets.LITHOSPHERE_STILL_LIFE);
        logMoves(moves, TerrainPresets.LITHOSPHERE_STILL_LIFE);
        scheduleSwap(moves);

        isTerraTonicActive = false;
        isEpicTerrainandWWEEActive = false;
        isLithoSphereAndStillLifeActive = true;
        isVanillaTerrainActive = false;
        saveState("LITHOSPHERE+STILL_LIFE");
    }

    public static void vanillaTerrainActive() throws Exception {
        List<Path[]> moves = buildMovesFor(TerrainPresets.VANILLA);
        logMoves(moves, TerrainPresets.VANILLA);
        scheduleSwap(moves);

        isTerraTonicActive = false;
        isEpicTerrainandWWEEActive = false;
        isLithoSphereAndStillLifeActive = false;
        isVanillaTerrainActive = true;
        saveState("VANILLA");
    }

    private static boolean matches(Path p, List<String> prefixes) {
        String name = p.getFileName().toString().toLowerCase();
        return name.endsWith(".jar") && prefixes.stream().anyMatch(name::startsWith);
    }

    private static List<Path[]> buildMovesFor(TerrainPresets chosen) throws IOException {
        Path modsDir = FMLPaths.MODSDIR.get();
        Path disabledDir = FMLPaths.GAMEDIR.get().resolve("disabled_mods");

        List<String> keep = PREFIXES.get(chosen);
        List<String> all = PREFIXES.values().stream().flatMap(List::stream).toList();
        List<Path[]> moves = new ArrayList<>();

        try (Stream<Path> stream = Files.list(modsDir)) {
            stream.filter(p -> matches(p, all) && !matches(p, keep))
                    .forEach(p -> moves.add(new Path[]{p, disabledDir.resolve(p.getFileName())}));
        }

        if (Files.isDirectory(disabledDir)) {
            try (Stream<Path> stream = Files.list(disabledDir)) {
                stream.filter(p -> matches(p, keep))
                        .forEach(p -> moves.add(new Path[]{p, modsDir.resolve(p.getFileName())}));
            }
        }
        return moves;
    }

    private static void logMoves(List<Path[]> moves, TerrainPresets chosen) {
        LOGGER.info("Preset {}: {} move(s) queued", chosen, moves.size());
        for (Path[] m : moves) {
            LOGGER.info("  {} -> {}", m[0], m[1]);
        }
    }

    private static void scheduleSwap(List<Path[]> moves) throws Exception {
        String java = ProcessHandle.current().info().command()
                .orElseGet(() -> Path.of(System.getProperty("java.home"), "bin", "java").toString());

        Path modJar = ModList.get().getModFileById("coregregation").getFile().getFilePath();

        List<String> cmd = new ArrayList<>(List.of(java, "-cp", modJar.toString(),
                ModSwapper.class.getName(), String.valueOf(ProcessHandle.current().pid())));
        for (Path[] m : moves) {
            cmd.add(m[0].toString());
            cmd.add(m[1].toString());
        }

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectOutput(ProcessBuilder.Redirect.DISCARD);
        pb.redirectError(ProcessBuilder.Redirect.DISCARD);
        pb.start();
    }

    //yep this half-AI cus again idk how to read/write files

    private static final Path STATE_FILE = FMLPaths.GAMEDIR.get().resolve("config/coregregation_active_preset.txt");
        public static void loadState() {
        String saved = "EPIC_TERRAIN_WWEE"; // default preset
        try {
            if (Files.exists(STATE_FILE)) {
                saved = Files.readString(STATE_FILE, StandardCharsets.UTF_8).trim();
            }
        } catch (IOException exception) {
            LOGGER.error("Couldn't read the active terrain preset, defaulting to Epic Terrain + WWEE", exception);
        }

        isTerraTonicActive = saved.equals("TERRATONIC");
        isEpicTerrainandWWEEActive = saved.equals("EPIC_TERRAIN_WWEE");
        isLithoSphereAndStillLifeActive = saved.equals("LITHOSPHERE_STILL_LIFE");
        isVanillaTerrainActive = saved.equals("VANILLA");

        if (!isTerraTonicActive && !isEpicTerrainandWWEEActive && !isLithoSphereAndStillLifeActive && !isVanillaTerrainActive) {
            isEpicTerrainandWWEEActive = true;
        }
    }

    private static void saveState(String presetId) {
        try {
            Files.createDirectories(STATE_FILE.getParent());
            Files.writeString(STATE_FILE, presetId, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            LOGGER.error("Couldn't persist the active terrain preset", exception);
        }
    }
}