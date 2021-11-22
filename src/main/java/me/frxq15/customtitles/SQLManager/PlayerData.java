package me.frxq15.customtitles.SQLManager;

import me.frxq15.customtitles.CustomTitles;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {
    private final static Map<UUID, PlayerData> players = new HashMap<>();
    private final UUID uuid;

    public PlayerData(UUID uuid){
        this.uuid = uuid;
        players.put(uuid, this);
    }
    public UUID getUUID() { return uuid; }

    public static PlayerData getPlayerData(CustomTitles Main, UUID uuid) {
        if (!players.containsKey(uuid)) {
            PlayerData playerData = new PlayerData(uuid);
        }
        return players.get(uuid);
    }
    public static Map<UUID, PlayerData> getAllPlayerData() { return players; }

}
