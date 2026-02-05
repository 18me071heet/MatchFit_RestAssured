package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class IoBuilder {
    private static final Logger logger = LogManager.getLogger("RestAssured");

    public static PrintStream toLog4j() {
        return new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                // Not used preferably
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                if (len == 0) return;
                String msg = new String(b, off, len);
                // remove trailing newlines to avoid extra gaps in logs
                if (!msg.trim().isEmpty()) { 
                    logger.info(msg.trim());
                }
            }
        });
    }
}
