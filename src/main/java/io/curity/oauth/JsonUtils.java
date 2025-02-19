package io.curity.oauth;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

final class JsonUtils {
    private static final String[] NO_SCOPES = {};

	private JsonUtils() {
    }


	static Set<String> getScopes(JsonObject jsonObject) {
        String scopesInToken = getString(jsonObject, "scope");
        String[] presentedScopes = scopesInToken == null ? NO_SCOPES : scopesInToken.split("\\s+");

        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(presentedScopes)));
    }

	static String getString(JsonObject jsonObject, String name) {
        return Optional.ofNullable(jsonObject.get(name))
				.filter(JsonElement::isJsonPrimitive).map(it -> it.getAsJsonPrimitive().getAsString())
                .orElse(null);
    }

	static long getLong(JsonObject jsonObject, String name) {
        return Optional.ofNullable(jsonObject.get(name))
				.filter(JsonElement::isJsonPrimitive).map(it -> it.getAsJsonPrimitive().getAsLong())
                .orElse(Long.MIN_VALUE);
    }
}