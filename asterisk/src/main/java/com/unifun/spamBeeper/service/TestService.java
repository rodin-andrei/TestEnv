package com.unifun.spamBeeper.service;


import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriVersion;
import ch.loway.oss.ari4java.generated.AriWSHelper;
import ch.loway.oss.ari4java.generated.models.*;
import ch.loway.oss.ari4java.tools.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final ARI ari;
    private Bridge b;

    private final AriWsListener ariWsListener;

    @EventListener
    @SneakyThrows
    public void test(ContextRefreshedEvent ctxStartEvt) {
        log.info("Test Service");
        connect();
    }


    public void connect() throws ARIException {
        log.info("Connected through ARI: " + ari.getVersion());

        AsteriskInfo ai = ari.asterisk().getInfo().execute();
        log.info("Hey! We're connected! Asterisk Version: " + ai.getSystem().getVersion());

        ari.eventsCallback(ariWsListener);
    }

    public void createBridge() throws ARIException {

        // create a bridge and start playing MOH on it
        // UGLY: we should have a constant for the allowed bridge types
        log.info("Creating a bridge");
        b = ari.bridges().create().setType("a4j-bridge1").setName("myBridge").execute();
        log.info("Bridge ID:" + b.getId() + " Name:" + b.getName() + " Tech:" + b.getTechnology() + " Creator:" + b.getCreator());

//        // start MOH on the bridge
//        log.info("Starting MOH on bridge");
//        ari.bridges().startMoh(b.getId()).execute();

        // check which bridges are available
        log.info("Listing bridges");
        List<Bridge> bridges = ari.bridges().list().execute();

        for (Bridge bb : bridges) {
            printBridge(bb);
        }
    }


    /**
     * The new style of event processing...
     *
     * @throws ARIException
     */
//    public void processEvents() throws ARIException {
//
//        log.info("Starting events... ");
//        MessageQueue mq = ari.getWebsocketQueue();
//
//        long start = System.currentTimeMillis();
//
//        Channel chan = ari.channels().originate("Local/100@wdep").setApp(APP_NAME)
//                .setExtension("100").setContext("wdep").setPriority(1).setTimeout(10000).execute();
//        log.info("Channel:" + chan.getId() + " in state " + chan.getState());
//
//        while ((System.currentTimeMillis() - start) < 10 * 1000L) {
//
//            Message m = mq.dequeueMax(100, 20);
//            if (m != null) {
//
//                long now = System.currentTimeMillis() - start;
//                log.info(now + ": " + m);
//
//                if (m instanceof StasisStart) {
//                    StasisStart event = (StasisStart) m;
//                    log.info("Channel found: " + event.getChannel().getId() + " State:" + event.getChannel().getState());
//
//                    ari.bridges().addChannel(b.getId(), event.getChannel().getId()).execute();
//                }
//            }
//        }
//
//        log.info("No more events... ");
//    }


    public void removeBridge() throws ARIException {

        log.info("Removing bridge....");

        ari.bridges().destroy(b.getId()).execute(new AriCallback<Void>() {

            @Override
            public void onSuccess(Void result) {
                log.info("Bridge destroyed ");
            }

            @Override
            public void onFailure(RestException e) {
                log.error("Failure in removeBridge() ", e);
            }
        });
    }

    /**
     * Dumps a bridge to string.
     * Should we have a default toString that makes more sense?
     *
     * @param b the bridge
     */
    private void printBridge(Bridge b) {
        log.info(". BridgeID:" + b.getId()
                + " Name:" + b.getName()
                + " Tech:" + b.getTechnology()
                + " Creator:" + b.getCreator()
                + " Class: " + b.getBridge_class()
                + " Type: " + b.getBridge_type()
                + " Chans: " + b.getChannels().size());
        for (String s : b.getChannels()) {
            log.info(" - ChannelID: " + s);
        }
    }
}
