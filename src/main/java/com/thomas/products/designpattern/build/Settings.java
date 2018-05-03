package com.thomas.products.designpattern.build;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yangyang32 on 16/10/6.
 * 在遇到多个构造器参数时候考虑build模式
 */
public class Settings {

    private ImmutableMap<String, String> settings;

    Settings(Map<String, String> settings) {
        this.settings = ImmutableSortedMap.copyOf(settings);
    }

    /**
     * Returns a builder to be used in order to build settings.
     */
    public static Builder settingsBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Settings{" +
                "settings=" + settings +
                '}';
    }

    public static class Builder {
        private final Map<String, String> map = new LinkedHashMap<>();

        private Builder() {
        }

        /**
         * Sets a setting with the provided setting key and value.
         *
         * @param key   The setting key
         * @param value The setting value
         * @return The builder
         */
        public Builder put(String key, String value) {
            map.put(key, value);
            return this;
        }

        /**
         * Sets the setting with the provided setting key and the int value.
         *
         * @param setting The setting key
         * @param value   The int value
         * @return The builder
         */
        public Builder put(String setting, int value) {
            put(setting, String.valueOf(value));
            return this;
        }

        /**
         * Builds a {@link Settings} (underlying uses {@link Settings}) based on everything
         * set on this builder.
         */
        public Settings build() {
            return new Settings(Collections.unmodifiableMap(map));
        }
    }
}
