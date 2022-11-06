package moe.pine.spring.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ByteArrayResource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NamedByteArrayResourceTest {
    @Nested
    class Initialize {
        @Test
        void success() {
            final byte[] bytes = {0x01, 0x02, 0x03};
            final String filename = "abc.txt";
            final ByteArrayResource resource = new NamedByteArrayResource(bytes, filename);

            assertEquals(filename, resource.getFilename());
            assertArrayEquals(bytes, resource.getByteArray());
        }
    }

    @Nested
    class Equals {
        @Test
        void equality() {
            final byte[] bytes = {0x01, 0x02, 0x03};
            final String filename = "abc.txt";
            final ByteArrayResource resource1 = new NamedByteArrayResource(bytes, filename);
            final ByteArrayResource resource2 = new NamedByteArrayResource(bytes, filename);

            assertEquals(resource1, resource1);
            assertEquals(resource1, resource2);
        }

        @Test
        void inequality() {
            final byte[] bytes = {0x01, 0x02, 0x03};
            final String filename1 = "abc.txt";
            final String filename2 = "bcd.txt";
            final ByteArrayResource resource1 = new NamedByteArrayResource(bytes, filename1);
            final ByteArrayResource resource2 = new NamedByteArrayResource(bytes, filename2);

            assertNotEquals(resource1, resource2);
        }
    }
}
