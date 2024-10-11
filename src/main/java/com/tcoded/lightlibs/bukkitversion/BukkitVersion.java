package com.tcoded.lightlibs.bukkitversion;

public enum BukkitVersion {

    v1_8_R3(MCVersion.v1_8_8),
    v1_9_R1(MCVersion.v1_9, MCVersion.v1_9_2),
    v1_9_R2(MCVersion.v1_9_4),
    v1_10_R1(MCVersion.v1_10_2),
    v1_11_R1(MCVersion.v1_11, MCVersion.v1_11_2),
    v1_12_R1(MCVersion.v1_12, MCVersion.v1_12_1, MCVersion.v1_12_2),
    v1_13_R1(MCVersion.v1_13),
    v1_13_R2(MCVersion.v1_13_1, MCVersion.v1_13_2),
    v1_14_R1(MCVersion.v1_14, MCVersion.v1_14_1, MCVersion.v1_14_2, MCVersion.v1_14_3, MCVersion.v1_14_4),
    v1_15_R1(MCVersion.v1_15, MCVersion.v1_15_1, MCVersion.v1_15_2),
    v1_16_R1(MCVersion.v1_16_1),
    v1_16_R2(MCVersion.v1_16_2, MCVersion.v1_16_3),
    v1_16_R3(MCVersion.v1_16_4, MCVersion.v1_16_5),
    v1_17_R1(MCVersion.v1_17, MCVersion.v1_17_1),
    v1_18_R1(MCVersion.v1_18, MCVersion.v1_18_1),
    v1_18_R2(MCVersion.v1_18_2),
    v1_19_R1(MCVersion.v1_19, MCVersion.v1_19_1, MCVersion.v1_19_2),
    v1_19_R2(MCVersion.v1_19_3),
    v1_19_R3(MCVersion.v1_19_4),
    v1_20_R1(MCVersion.v1_20, MCVersion.v1_20_1),
    v1_20_R2(MCVersion.v1_20_2),
    v1_20_R3(MCVersion.v1_20_4),
    v1_20_R4(MCVersion.v1_20_5, MCVersion.v1_20_6),
    v1_21_R1(MCVersion.v1_21)
    ;

    // Need to be generated, let's do it only once
    public static final BukkitVersion[] VALUES = values();

    public static BukkitVersion getLatest() {
        return VALUES[VALUES.length - 1];
    }

    private final MCVersion[] mcVersions;

    BukkitVersion(MCVersion... mcVersions) {
        this.mcVersions = mcVersions;
    }

    public boolean greaterThan(BukkitVersion version) {
        return this.ordinal() > version.ordinal();
    }

    public boolean greaterOrEqThan(BukkitVersion version) {
        return this.ordinal() >= version.ordinal();
    }

    public boolean lessThan(BukkitVersion version) {
        return this.ordinal() < version.ordinal();
    }

    public boolean lessOrEqThan(BukkitVersion version) {
        return this.ordinal() <= version.ordinal();
    }

    public boolean isWithin(BukkitVersion versionLow, BukkitVersion versionHigh) {
        return this.greaterOrEqThan(versionLow) && this.lessOrEqThan(versionHigh);
    }

    public MCVersion[] getMcVersions() {
        return mcVersions;
    }

}
