package com.djbberko.guardiansscouter;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Guardians Scouter"
)
public class GuardiansScouterPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private GuardiansScouterConfig config;

//	@Inject
//	private OverlayManager overlayManager;

//	@Inject
//	private GuardiansScouterOverlayPanel overlayPanel;

	@Inject
	private ClientToolbar clientToolbar;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Guardians Scouter started!");
//		overlayManager.add(overlayPanel);
		loadPluginPanel();
	}

	private void loadPluginPanel()
	{
		if (navButton != null)
		{
			clientToolbar.removeNavigation(navButton);
		}
		panel = new GuardiansScouterPanel(this);
		navButton = NavigationButton.builder().tooltip("Wintertodt Scouter").icon(icon).priority(7).panel(wintertodtScouterPanel).build();
		clientToolbar.addNavigation(navButton);

	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Guardians Scouter stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Guardians Scouter says " + config.greeting(), null);
		}
	}

	@Provides
	GuardiansScouterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GuardiansScouterConfig.class);
	}
}
