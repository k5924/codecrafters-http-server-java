package handlers;

import utils.BufferPool;
import utils.HandlerTools;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

import static utils.Constants.NOT_FOUND_BYTES;

public final class NotFoundHandler implements ResponseHandler{

    private final BufferPool bufferPool;

    public NotFoundHandler(final BufferPool bufferPool) {
        this.bufferPool = bufferPool;
    }

    @Override
    public void writeResponse(final AsynchronousSocketChannel clientChannel, final ByteBuffer byteBuffer) {
        byteBuffer.put(NOT_FOUND_BYTES);
        HandlerTools.cleanupConnection(clientChannel, byteBuffer, bufferPool);
    }
}
