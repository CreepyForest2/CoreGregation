package net.creepyforest.coregregation.common.world_preset;

import java.io.IOException;
import java.nio.file.*;



//YES THIS IS VIBECODED IM REALLY SORRY pls dont cut my head off
//i dont have the knowledge to properly make something like this and if i were to learn this update wouldnt see the light of day till 2028
//i will replace with my stuff when i learn how to do it, till then really sorry man

public final class ModSwapper {
    public static void main(String[] args) throws Exception {
        long pid = Long.parseLong(args[0]);
        ProcessHandle.of(pid).ifPresent(p -> p.onExit().join());

        for (int i = 1; i + 1 < args.length; i += 2) {
            Path from = Path.of(args[i]);
            Path to = Path.of(args[i + 1]);
            for (int attempt = 0; attempt < 20; attempt++) {
                try {
                    Files.createDirectories(to.getParent());
                    Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
                    break;
                } catch (IOException e) {
                    Thread.sleep(250);
                }
            }
        }
    }
}