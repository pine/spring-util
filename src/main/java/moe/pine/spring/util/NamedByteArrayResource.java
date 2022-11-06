package moe.pine.spring.util;

import org.springframework.core.io.ByteArrayResource;

import java.util.Objects;

/**
 * ByteArrayResource with filename
 *
 * @author Pine Mizune
 * @see ByteArrayResource
 * @since 0.1.1
 */
public class NamedByteArrayResource extends ByteArrayResource {
    private final String filename;

    /**
     * Create a new NamedByteArrayResource with filename
     *
     * @param byteArray the byte array to wrap
     * @param filename the filename of the resource
     */
    public NamedByteArrayResource(byte[] byteArray, String filename) {
        super(byteArray);
        this.filename = filename;
    }

    /**
     * Return filename
     *
     * @return the filename of the resource
     */
    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedByteArrayResource)) return false;
        if (!super.equals(o)) return false;
        NamedByteArrayResource that = (NamedByteArrayResource) o;
        return filename.equals(that.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), filename);
    }
}
