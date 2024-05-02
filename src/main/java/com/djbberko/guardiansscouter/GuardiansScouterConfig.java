package com.djbberko.guardiansscouter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("guardiansscouter")
public interface GuardiansScouterConfig extends Config
{
	String NETWORK_UPLINK = "get uplink";
	String NETWORK_DOWNLINK = "get downlink";

	default String greeting()
	{
		return "Hello";
	}
	@ConfigItem(keyName = NETWORK_UPLINK,
			position = 0,
			name = "Realtime Uplink",
			description = "Web endpoint to upload rift data from"
	)
	default String uplink()
	{
		return "https://www.guardiansscouter.com/scouter";
	}

	@ConfigItem(keyName = NETWORK_DOWNLINK,
			position = 1,
			name = "Realtime Downlink",
			description = "Web endpoint to get rift data from"
	)
	default String downlink()
	{
		return "https://www.guardiansscouter.com/scouter";
	}

	@ConfigItem(
			keyName = "worldHopperEnabled",
			position = 2,
			name = "Double click to Hop",
			description = "Enables double clicking worlds in the side view panels to quick-hop to them"
	)
	default boolean isWorldHopperEnabled()
	{
		return true;
	}
}
