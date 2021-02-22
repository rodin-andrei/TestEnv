package com.unifun.spamBeeper.service.impl;

import ch.loway.oss.ari4java.generated.AriWSHelper;
import ch.loway.oss.ari4java.generated.models.*;
import ch.loway.oss.ari4java.tools.AriConnectionEvent;
import ch.loway.oss.ari4java.tools.RestException;
import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.repository.PlayBackCallbackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AriWsListener extends AriWSHelper {
    private final CallProcessService callProcessService;

    private final PlayBackCallbackRepository playBackCallbackRepository;

    @Override
    protected void onStasisStart(StasisStart message) {
        CallInfo callInfo = CallInfo.builder()
                .calledMsisdn(message.getChannel().getDialplan().getExten())
                .callingMsisdn(message.getChannel().getCaller().getNumber())
                .channelId(message.getChannel().getId())
                .build();
        callProcessService.startCallProcess(callInfo);
    }

    @Override
    protected void onStasisEnd(StasisEnd message) {
        log.trace("onStasisEnd" + message);
    }

    @Override
    public void onFailure(RestException e) {
        log.error("onFailure: {}", e.getMessage(), e);
    }

    @Override
    public void onConnectionEvent(AriConnectionEvent event) {
        log.trace("onConnectionEvent" + event);
    }

    @Override
    protected void onChannelEnteredBridge(ChannelEnteredBridge message) {
        log.trace("onChannelEnteredBridge" + message);
    }

    @Override
    protected void onPlaybackContinuing(PlaybackContinuing message) {
        log.trace("onPlaybackContinuing" + message);
    }

    @Override
    protected void onPeerStatusChange(PeerStatusChange message) {
        log.trace("onPeerStatusChange" + message);
    }

    @Override
    protected void onChannelLeftBridge(ChannelLeftBridge message) {
        log.trace("onChannelLeftBridge" + message);
    }

    @Override
    protected void onChannelVarset(ChannelVarset message) {
        log.trace("onChannelVarset" + message);
    }

    @Override
    protected void onTextMessageReceived(TextMessageReceived message) {
        log.trace("onTextMessageReceived" + message);
    }

    @Override
    protected void onChannelConnectedLine(ChannelConnectedLine message) {
        log.trace("onChannelConnectedLine" + message);
    }

    @Override
    protected void onChannelUnhold(ChannelUnhold message) {
        log.trace("onChannelUnhold" + message);
    }

    @Override
    protected void onEndpointStateChange(EndpointStateChange message) {
        log.trace("onEndpointStateChange" + message);
    }

    @Override
    protected void onPlaybackStarted(PlaybackStarted message) {
        log.trace("onPlaybackStarted" + message);
    }


    @Override
    protected void onChannelDialplan(ChannelDialplan message) {
        log.trace("onChannelDialplan" + message);
    }

    @Override
    protected void onChannelDtmfReceived(ChannelDtmfReceived message) {
        log.trace("onChannelDtmfReceived" + message);
        log.debug("Digit: " + message.getDigit());
    }

    @Override
    protected void onDeviceStateChanged(DeviceStateChanged message) {
        log.trace("onDeviceStateChanged" + message);
    }

    @Override
    protected void onApplicationReplaced(ApplicationReplaced message) {
        log.trace("onApplicationReplaced" + message);
    }

    @Override
    protected void onContactInfo(ContactInfo message) {
        log.trace("onContactInfo" + message);
    }

    @Override
    protected void onRecordingFailed(RecordingFailed message) {
        log.trace("onRecordingFailed" + message);
    }

    @Override
    protected void onChannelStateChange(ChannelStateChange message) {
        log.trace("onChannelStateChange" + message);
    }

    @Override
    protected void onBridgeBlindTransfer(BridgeBlindTransfer message) {
        log.trace("onBridgeBlindTransfer" + message);
    }

    @Override
    protected void onBridgeDestroyed(BridgeDestroyed message) {
        log.trace("onBridgeDestroyed" + message);
    }

    @Override
    protected void onBridgeMerged(BridgeMerged message) {
        log.trace("onBridgeMerged" + message);
    }

    @Override
    protected void onRecordingStarted(RecordingStarted message) {
        log.trace("onRecordingStarted" + message);
    }

    @Override
    protected void onPeer(Peer message) {
        log.trace("onPeer" + message);
    }

    @Override
    protected void onApplicationMoveFailed(ApplicationMoveFailed message) {
        log.trace("onApplicationMoveFailed" + message);
    }

    @Override
    protected void onMissingParams(MissingParams message) {
        log.trace("onMissingParams" + message);
    }

    @Override
    protected void onChannelCreated(ChannelCreated message) {
        log.trace("onChannelCreated" + message);
    }

    @Override
    protected void onRecordingFinished(RecordingFinished message) {
        log.trace("onRecordingFinished" + message);
    }

    @Override
    protected void onChannelHangupRequest(ChannelHangupRequest message) {
        log.trace("onChannelHangupRequest" + message);
    }

    @Override
    protected void onDial(Dial message) {
        log.trace("onDial" + message);
    }

    @Override
    protected void onChannelTalkingFinished(ChannelTalkingFinished message) {
        log.trace("onChannelTalkingFinished" + message);
    }

    @Override
    protected void onContactStatusChange(ContactStatusChange message) {
        log.trace("onContactStatusChange" + message);
    }

    @Override
    protected void onChannelTalkingStarted(ChannelTalkingStarted message) {
        log.trace("onChannelTalkingStarted" + message);
    }

    @Override
    protected void onPlaybackFinished(PlaybackFinished message) {
        log.trace("onPlaybackFinished" + message);
        playBackCallbackRepository.findByPlayBackId(message.getPlayback().getId())
                .ifPresent(playbackCallBack -> playbackCallBack.onSuccess(message.getPlayback()));
    }

    @Override
    protected void onBridgeCreated(BridgeCreated message) {
        log.trace("onBridgeCreated" + message);
    }

    @Override
    protected void onChannelDestroyed(ChannelDestroyed message) {
        log.trace("onChannelDestroyed" + message);
    }

    @Override
    protected void onChannelHold(ChannelHold message) {
        log.trace("onChannelHold" + message);
    }

    @Override
    protected void onChannelUserevent(ChannelUserevent message) {
        log.trace("onChannelUserevent" + message);
    }

    @Override
    protected void onBridgeVideoSourceChanged(BridgeVideoSourceChanged message) {
        log.trace("onBridgeVideoSourceChanged" + message);
    }

    @Override
    protected void onBridgeAttendedTransfer(BridgeAttendedTransfer message) {
        log.trace("onBridgeAttendedTransfer" + message);
    }

    @Override
    protected void onChannelCallerId(ChannelCallerId message) {
        log.trace("onChannelCallerId" + message);
    }

}
