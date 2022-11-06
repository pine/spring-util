package moe.pine.spring.util;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ByteArrayResource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NamedByteArrayResourceTest {
    @Test
    void init() {
        final byte[] bytes = {0x01, 0x02, 0x03};
        final String filename = "abc.txt";
        final ByteArrayResource resource = new NamedByteArrayResource(bytes, filename);

        assertEquals(filename, resource.getFilename());
        assertArrayEquals(bytes, resource.getByteArray());
    }
}
