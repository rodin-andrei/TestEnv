package in.arod.testEnv.core.network.network.netty.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleProcessingHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf tmp;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("Handler added");
        tmp = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("Handler removed");
        tmp.release();
        tmp = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg;
        tmp.writeBytes(m);
        m.release();
        System.out.printf(String.valueOf(tmp.readByte()));
        if (tmp.readableBytes() >= 4) {
            //request processing
//            final TestRequestMessage testRequestMessage = new TestRequestMessage();
//            testRequestMessage.setCommandId(1);
//            testRequestMessage.setSequenceNumber(11500l);
//            testRequestMessage.setMsisdn("69744353");
            ChannelFuture future = ctx.writeAndFlush("buybuybuybuybuybuybuybuy");
//            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
}