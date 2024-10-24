package com.tcoded.lightlibs.bukkitversion;

import java.util.Objects;

public enum MCVersion {

    v1_8_8 (BukkitVersion.v1_8_R3),
    v1_9 (BukkitVersion.v1_9_R1),
    v1_9_1 (BukkitVersion.v1_9_R1),
    v1_9_2 (BukkitVersion.v1_9_R1),
//    v1_9_3 (BukkitVersion.v1_9_R1), // todo
    v1_9_4 (BukkitVersion.v1_9_R2),
    v1_10 (BukkitVersion.v1_10_R1),
    v1_10_1 (BukkitVersion.v1_10_R1),
    v1_10_2 (BukkitVersion.v1_10_R1),
    v1_11 (BukkitVersion.v1_11_R1),
    v1_11_1 (BukkitVersion.v1_11_R1),
    v1_11_2 (BukkitVersion.v1_11_R1),
    v1_12 (BukkitVersion.v1_12_R1),
    v1_12_1 (BukkitVersion.v1_12_R1),
    v1_12_2 (BukkitVersion.v1_12_R1),
    v1_13 (BukkitVersion.v1_13_R1),
    v1_13_1 (BukkitVersion.v1_13_R2),
    v1_13_2 (BukkitVersion.v1_13_R2),
    v1_14 (BukkitVersion.v1_14_R1),
    v1_14_1 (BukkitVersion.v1_14_R1),
    v1_14_2 (BukkitVersion.v1_14_R1),
    v1_14_3 (BukkitVersion.v1_14_R1),
    v1_14_4 (BukkitVersion.v1_14_R1),
    v1_15 (BukkitVersion.v1_15_R1),
    v1_15_1 (BukkitVersion.v1_15_R1),
    v1_15_2 (BukkitVersion.v1_15_R1),
    v1_16 (BukkitVersion.v1_16_R1),
    v1_16_1 (BukkitVersion.v1_16_R1),
    v1_16_2 (BukkitVersion.v1_16_R2),
    v1_16_3 (BukkitVersion.v1_16_R2),
    v1_16_4 (BukkitVersion.v1_16_R3),
    v1_16_5 (BukkitVersion.v1_16_R3),
    v1_17 (BukkitVersion.v1_17_R1),
    v1_17_1 (BukkitVersion.v1_17_R1),
    v1_18 (BukkitVersion.v1_18_R1),
    v1_18_1 (BukkitVersion.v1_18_R1),
    v1_18_2 (BukkitVersion.v1_18_R2),
    v1_19 (BukkitVersion.v1_19_R1),
    v1_19_1 (BukkitVersion.v1_19_R1),
    v1_19_2 (BukkitVersion.v1_19_R1),
    v1_19_3 (BukkitVersion.v1_19_R2),
    v1_19_4 (BukkitVersion.v1_19_R3),
    v1_20 (BukkitVersion.v1_20_R1),
    v1_20_1 (BukkitVersion.v1_20_R1),
    v1_20_2 (BukkitVersion.v1_20_R2),
//    v1_20_3 (BukkitVersion.v1_20_R2), // todo
    v1_20_4 (BukkitVersion.v1_20_R3),
    v1_20_5 (BukkitVersion.v1_20_R4),
    v1_20_6 (BukkitVersion.v1_20_R4),
    v1_21 (BukkitVersion.v1_21_R1),
    v1_21_1 (BukkitVersion.v1_21_R1),
    v1_21_2 (BukkitVersion.v1_21_R2),
    v1_21_3 (BukkitVersion.v1_21_R2),
    ;

    // Need to be generated, let's do it only once
    public static final MCVersion[] VALUES = values();

    public static MCVersion fromMcVersion(String mcVersion) {
        Objects.requireNonNull(mcVersion, "mcVersion cannot be null");

        String search = "v" + mcVersion.replace(".", "_");
        for (MCVersion nmsVersion : values()) {
            if (search.equals(nmsVersion.name())) {
                return nmsVersion;
            }
        }

        return null;
    }

    public static MCVersion fromServerVersion(String serverVersion) {
        Objects.requireNonNull(serverVersion, "serverVersion cannot be null");

        String mcVersionSection = serverVersion.split("-")[0];
        return fromMcVersion(mcVersionSection);
    }

    public static MCVersion getLatest() {
        return VALUES[VALUES.length - 1];
    }

    private final BukkitVersion bukkitVer;

    MCVersion(BukkitVersion bukkitVer) {
        this.bukkitVer = bukkitVer;
    }

    public boolean greaterThan(MCVersion version) {
        return this.ordinal() > version.ordinal();
    }

    public boolean greaterOrEqThan(MCVersion version) {
        return this.ordinal() >= version.ordinal();
    }

    public boolean lessThan(MCVersion version) {
        return this.ordinal() < version.ordinal();
    }

    public boolean lessOrEqThan(MCVersion version) {
        return this.ordinal() <= version.ordinal();
    }

    public boolean isWithin(MCVersion versionLow, MCVersion versionHigh) {
        return this.greaterOrEqThan(versionLow) && this.lessOrEqThan(versionHigh);
    }

    public BukkitVersion toBukkitVersion() {
        return bukkitVer;
    }

}
