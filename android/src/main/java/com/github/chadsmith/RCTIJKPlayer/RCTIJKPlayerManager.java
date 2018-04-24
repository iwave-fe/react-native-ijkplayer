package com.github.chadsmith.RCTIJKPlayer;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.chadsmith.RCTIJKPlayer.RCTIJKPlayer.Events;

import java.io.IOException;
import java.util.Map;

public class RCTIJKPlayerManager extends SimpleViewManager<RCTIJKPlayer> {

    private static final String REACT_CLASS = "RCTIJKPlayer";

    public static final String PROP_SRC = "src";
    public static final String PROP_SRC_OPTIONS = "options";
    public static final String PROP_SRC_URI = "uri";
    public static final String PROP_MUTED = "muted";
    public static final String PROP_PAUSED = "paused";
    public static final String PROP_VOLUME = "volume";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public RCTIJKPlayer createViewInstance(ThemedReactContext context) {
        return new RCTIJKPlayer(context);
    }

    @Override
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        for (Events event : Events.values()) {
            builder.put(event.toString(), MapBuilder.of("registrationName", event.toString()));
        }
        return builder.build();
    }

    @ReactProp(name = PROP_SRC)
    public void setSrc(final RCTIJKPlayer videoView, @Nullable ReadableMap src) throws IOException {
        videoView.setSrc(src.getString(PROP_SRC_URI), src.getArray(PROP_SRC_OPTIONS).toArrayList());
    }

    @ReactProp(name = PROP_MUTED, defaultBoolean = false)
    public void setMuted(final RCTIJKPlayer videoView, final boolean muted) {
        videoView.setMutedModifier(muted);
    }

    @ReactProp(name = PROP_PAUSED, defaultBoolean = false)
    public void setPaused(final RCTIJKPlayer videoView, final boolean paused) {
        videoView.setPausedModifier(paused);
    }

}