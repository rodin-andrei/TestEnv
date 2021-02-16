package com.unifun.spamBeeper.service;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.generated.AriWSHelper;
import ch.loway.oss.ari4java.generated.models.*;
import ch.loway.oss.ari4java.tools.AriConnectionEvent;
import ch.loway.oss.ari4java.tools.RestException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AriWsListener extends AriWSHelper {
    private final ARI ari;
    private String sound= "yourcallisimportant";

    @Override
    @SneakyThrows
    protected void onStasisStart(StasisStart message) {
        log.info("onStasisStart" + message);
        ari.channels().play(message.getChannel().getId(), "sound:"+sound).execute();
        ari.channels().hangup(message.getChannel().getId());
    }

    @Override
    protected void onStasisEnd(StasisEnd message) {
        log.info("onStasisEnd" + message);
    }

    @Override
    public void onFailure(RestException e) {
        log.error("onFailure: {}", e.getMessage(), e);
    }

    @Override
    public void onConnectionEvent(AriConnectionEvent event) {
        log.info("onConnectionEvent" + event);
    }

    @Override
    protected void onChannelEnteredBridge(ChannelEnteredBridge message) {
        log.info("onChannelEnteredBridge" + message);
    }

    @Override
    protected void onPlaybackContinuing(PlaybackContinuing message) {
        log.info("onPlaybackContinuing" + message);
    }

    @Override
    protected void onPeerStatusChange(PeerStatusChange message) {
        log.info("onPeerStatusChange" + message);
    }

    @Override
    protected void onChannelLeftBridge(ChannelLeftBridge message) {
        log.info("onChannelLeftBridge" + message);
    }

    @Override
    protected void onChannelVarset(ChannelVarset message) {
        log.info("onChannelVarset" + message);
    }

    @Override
    protected void onTextMessageReceived(TextMessageReceived message) {
        log.info("onTextMessageReceived" + message);
    }

    @Override
    protected void onChannelConnectedLine(ChannelConnectedLine message) {
        log.info("onChannelConnectedLine" + message);
    }

    @Override
    protected void onChannelUnhold(ChannelUnhold message) {
        log.info("onChannelUnhold" + message);
    }

    @Override
    protected void onEndpointStateChange(EndpointStateChange message) {
        log.info("onEndpointStateChange" + message);
    }

    @Override
    protected void onPlaybackStarted(PlaybackStarted message) {
        log.info("onPlaybackStarted" + message);
    }


    @Override
    protected void onChannelDialplan(ChannelDialplan message) {
        log.info("onChannelDialplan" + message);
    }

    @Override
    protected void onChannelDtmfReceived(ChannelDtmfReceived message) {
        log.info("onChannelDtmfReceived" + message);
    }

    @Override
    protected void onDeviceStateChanged(DeviceStateChanged message) {
        log.info("onDeviceStateChanged" + message);
    }

    @Override
    protected void onApplicationReplaced(ApplicationReplaced message) {
        log.info("onApplicationReplaced" + message);
    }

    @Override
    protected void onContactInfo(ContactInfo message) {
        log.info("onContactInfo" + message);
    }

    @Override
    protected void onRecordingFailed(RecordingFailed message) {
        log.info("onRecordingFailed" + message);
    }

    @Override
    protected void onChannelStateChange(ChannelStateChange message) {
        log.info("onChannelStateChange" + message);
    }

    @Override
    protected void onBridgeBlindTransfer(BridgeBlindTransfer message) {
        log.info("onBridgeBlindTransfer" + message);
    }

    @Override
    protected void onBridgeDestroyed(BridgeDestroyed message) {
        log.info("onBridgeDestroyed" + message);
    }

    @Override
    protected void onBridgeMerged(BridgeMerged message) {
        log.info("onBridgeMerged" + message);
    }

    @Override
    protected void onRecordingStarted(RecordingStarted message) {
        log.info("onRecordingStarted" + message);
    }

    @Override
    protected void onPeer(Peer message) {
        log.info("onPeer" + message);
    }

    @Override
    protected void onApplicationMoveFailed(ApplicationMoveFailed message) {
        log.info("onApplicationMoveFailed" + message);
    }

    @Override
    protected void onMissingParams(MissingParams message) {
        log.info("onMissingParams" + message);
    }

    @Override
    protected void onChannelCreated(ChannelCreated message) {
        log.info("onChannelCreated" + message);
    }

    @Override
    protected void onRecordingFinished(RecordingFinished message) {
        log.info("onRecordingFinished" + message);
    }

    @Override
    protected void onChannelHangupRequest(ChannelHangupRequest message) {
        log.info("onChannelHangupRequest" + message);
    }

    @Override
    protected void onDial(Dial message) {
        log.info("onDial" + message);
    }

    @Override
    protected void onChannelTalkingFinished(ChannelTalkingFinished message) {
        log.info("onChannelTalkingFinished" + message);
    }

    @Override
    protected void onContactStatusChange(ContactStatusChange message) {
        log.info("onContactStatusChange" + message);
    }

    @Override
    protected void onChannelTalkingStarted(ChannelTalkingStarted message) {
        log.info("onChannelTalkingStarted" + message);
    }

    @Override
    protected void onPlaybackFinished(PlaybackFinished message) {
        log.info("onPlaybackFinished" + message);
    }

    @Override
    protected void onBridgeCreated(BridgeCreated message) {
        log.info("onBridgeCreated" + message);
    }

    @Override
    protected void onChannelDestroyed(ChannelDestroyed message) {
        log.info("onChannelDestroyed" + message);
    }

    @Override
    protected void onChannelHold(ChannelHold message) {
        log.info("onChannelHold" + message);
    }

    @Override
    protected void onChannelUserevent(ChannelUserevent message) {
        log.info("onChannelUserevent" + message);
    }

    @Override
    protected void onBridgeVideoSourceChanged(BridgeVideoSourceChanged message) {
        log.info("onBridgeVideoSourceChanged" + message);
    }

    @Override
    protected void onBridgeAttendedTransfer(BridgeAttendedTransfer message) {
        log.info("onBridgeAttendedTransfer" + message);
    }

    @Override
    protected void onChannelCallerId(ChannelCallerId message) {
        log.info("onChannelCallerId" + message);
    }

    public void setSoundName(String sound) {
        this.sound= sound;
    }
}
