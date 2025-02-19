package io.curity.oauth;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.time.Instant;
import java.util.Set;

public class JsonData implements Expirable {
    private final JsonObject _jsonObject;
    private final Set<String> _scopes;

	JsonData(JsonObject jsonObject) {
        _jsonObject = jsonObject;
        _scopes = JsonUtils.getScopes(jsonObject);
    }

	JsonObject getJsonObject() {
        return _jsonObject;
    }

	public String getSubject() {
        return JsonUtils.getString(_jsonObject, "sub");
    }

	public Set<String> getScopes() {
        return _scopes;
    }

	public Set<String> getClaimNames() {
        return _jsonObject.keySet();
    }

	public JsonObject getClaims() {
        return _jsonObject;
    }

	public JsonElement getClaim(String claimName) {
        return _jsonObject.get(claimName);
    }

    @Override
	public Instant getExpiresAt() {
        return Instant.ofEpochSecond(JsonUtils.getLong(_jsonObject, "exp"));
    }
}