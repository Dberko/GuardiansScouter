package com.djbberko.guardiansscouter;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GuardiansScouterPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GuardiansScouterPlugin.class);
		RuneLite.main(args);
	}
}