package com.djbberko.guardiansscouter;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GuardiansScouterPluginTest
{
	public static void main(String[] args) throws Exception
	{
        //noinspection unchecked
        ExternalPluginManager.loadBuiltin(GuardiansScouterPlugin.class);
		System.out.println("TEST");
		RuneLite.main(args);
	}
}