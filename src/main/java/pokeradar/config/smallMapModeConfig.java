package pokeradar.config;

import pokeradar.gui.ModGuiConfig.ModBooleanEntry;
import pokeradar.gui.ModGuiConfigHUD.MapPosConfigEntry;

public class smallMapModeConfig extends largeMapModeConfig
{
	public smallMapModeConfig(String configCategory)
	{
		super(configCategory);
	}

	@Override
	public void loadConfig()
	{
		super.loadConfig();
		ConfigurationHandler.configuration.getCategory(this.configCategory).remove("Position");
		ConfigurationHandler.configuration.getCategory(this.configCategory).remove("heightPercent");
	}

	@Override
	public void setDefaults()
	{
		this.rotateDef = true;
		this.circularDef = true;
		this.coordsModeDef = coordsModeStringArray[1];
		this.biomeModeDef = coordsModeStringArray[2];
		this.borderModeDef = true;
		this.playerArrowSizeDef = 4;
		this.markerSizeDef = 3;
		this.heightPercentDef = 30;
		this.xPosDef = 97.5;
		this.yPosDef = 5 + 12;
		this.heightPercentDef = 30;
		this.widthPercentDef = 30;

		ConfigurationHandler.configuration
				.get(this.configCategory, "enabled", this.enabledDef)
				.setRequiresWorldRestart(true);

		ConfigurationHandler.configuration
				.get(this.configCategory, "rotate", this.rotate)
				.setConfigEntryClass(ModBooleanEntry.class);

		ConfigurationHandler.configuration
				.getCategory(this.mapPosCategory)
				.setLanguageKey("mw.config.map.ctgy.position")
				.setConfigEntryClass(MapPosConfigEntry.class)
				.setShowInGui(true);
	}
}
