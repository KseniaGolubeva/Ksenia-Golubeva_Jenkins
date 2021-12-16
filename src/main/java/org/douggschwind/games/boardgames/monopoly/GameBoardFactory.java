package org.douggschwind.games.boardgames.monopoly;

import java.util.ArrayList;
import java.util.List;

import org.douggschwind.games.boardgames.monopoly.space.BoardSpace;
import org.douggschwind.games.boardgames.monopoly.space.ChanceSpace;
import org.douggschwind.games.boardgames.monopoly.space.CommunityChestSpace;
import org.douggschwind.games.boardgames.monopoly.space.FreeParkingSpace;
import org.douggschwind.games.boardgames.monopoly.space.GoDirectlyToJailSpace;
import org.douggschwind.games.boardgames.monopoly.space.GoSpace;
import org.douggschwind.games.boardgames.monopoly.space.IncomeTaxSpace;
import org.douggschwind.games.boardgames.monopoly.space.JailSpace;
import org.douggschwind.games.boardgames.monopoly.space.LuxuryTaxSpace;
import org.douggschwind.games.boardgames.monopoly.space.PropertyBoardSpace;
import org.douggschwind.games.boardgames.monopoly.space.RailroadBoardSpace;
import org.douggschwind.games.boardgames.monopoly.space.UtilityBoardSpace;
import org.douggschwind.games.boardgames.monopoly.title.MonopolyDefinition;
import org.douggschwind.games.boardgames.monopoly.title.MonopolyDefinition.Identifier;
import org.douggschwind.games.boardgames.monopoly.title.MonopolyDefinition.Type;
import org.douggschwind.games.boardgames.monopoly.title.Title;
import org.douggschwind.games.boardgames.monopoly.title.TitleDeed;

/**
 * Creates the game board by binding well known Monopoly Definitions to well known TitleDeed instances
 * and lastly those into BoardSpace instances.
 * @author Doug Gschwind
 */
public class GameBoardFactory {
	
	static final int NUM_BOARD_SPACES_TOTAL = 40;
	
	static final int GO_SPACE_INDEX = 0;
	static final int READING_RAILROAD_SPACE_INDEX = 5;
	static final int JAIL_SPACE_INDEX = 10;
	static final int ST_CHARLES_PLACE_SPACE_INDEX = 11;
	static final int ELECTRIC_COMPANY_SPACE_INDEX = 12;
	static final int PENNSYLVANIA_RAILROAD_SPACE_INDEX = 15;
	static final int FREE_PARKING_SPACE_INDEX = 20;
	static final int ILLINOIS_AVENUE_SPACE_INDEX = 24;
	static final int B_O_RAILROAD_SPACE_INDEX = 25;
	static final int WATER_WORKS_SPACE_INDEX = 28;
	static final int GO_DIRECTLY_TO_JAIL_SPACE_INDEX = 30;
	static final int SHORT_LINE_RAILROAD_SPACE_INDEX = 35;
	static final int BOARDWALK_SPACE_INDEX = 39;
	
	private static final MonopolyDefinition BROWN_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.Brown, Type.Property);
	private static final MonopolyDefinition LIGHT_BLUE_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.LightBlue, Type.Property);
	private static final MonopolyDefinition PURPLE_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.Purple, Type.Property);
	private static final MonopolyDefinition ORANGE_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.Orange, Type.Property);
	private static final MonopolyDefinition RED_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.Red, Type.Property);
	private static final MonopolyDefinition YELLOW_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.Yellow, Type.Property);
	private static final MonopolyDefinition GREEN_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.Green, Type.Property);
	private static final MonopolyDefinition BLUE_MONOPOLY_DEFINITION = new MonopolyDefinition(Identifier.Blue, Type.Property);
	private static final MonopolyDefinition RAILROADS_DEFINITION = new MonopolyDefinition(Identifier.Railroads, Type.Railroad);
	private static final MonopolyDefinition UTILITIES_DEFINITION = new MonopolyDefinition(Identifier.Utilities, Type.Utility);
	
	public static final TitleDeed MEDITERRANEAN_AVENUE = new TitleDeed(BROWN_MONOPOLY_DEFINITION, "Mediterranean Avenue", 60, 50, 2, 4, 10, 30, 90, 160, 250);
	private static final TitleDeed BALTIC_AVENUE = new TitleDeed(BROWN_MONOPOLY_DEFINITION, "Baltic Avenue", 60, 50, 4, 8, 20, 60, 180, 320, 450);
	
	private static final TitleDeed ORIENTAL_AVENUE = new TitleDeed(LIGHT_BLUE_MONOPOLY_DEFINITION, "Oriental Avenue", 100, 50, 6, 12, 30, 90, 270, 400, 550);
	private static final TitleDeed VERMONT_AVENUE = new TitleDeed(LIGHT_BLUE_MONOPOLY_DEFINITION, "Vermont Avenue", 100, 50, 6, 12, 30, 90, 270, 400, 550);
	private static final TitleDeed CONNECTICUT_AVENUE = new TitleDeed(LIGHT_BLUE_MONOPOLY_DEFINITION, "Connecticut Avenue", 120, 50, 8, 16, 40, 100, 300, 450, 600);
	
	private static final TitleDeed ST_CHARLES_PLACE = new TitleDeed(PURPLE_MONOPOLY_DEFINITION, "St Charles Place", 140, 100, 10, 20, 50, 150, 450, 625, 750);
	private static final TitleDeed STATES_AVENUE = new TitleDeed(PURPLE_MONOPOLY_DEFINITION, "States Avenue", 140, 100, 10, 20, 50, 150, 450, 625, 750);
	private static final TitleDeed VIRGINIA_AVENUE = new TitleDeed(PURPLE_MONOPOLY_DEFINITION, "Virginia Avenue", 160, 100, 12, 24, 60, 180, 500, 700, 900);
	
	private static final TitleDeed ST_JAMES_PLACE = new TitleDeed(ORANGE_MONOPOLY_DEFINITION, "St James Place", 180, 100, 14, 28, 70, 200, 550, 750, 950);
	private static final TitleDeed TENNESSEE_AVENUE = new TitleDeed(ORANGE_MONOPOLY_DEFINITION, "Tennessee Avenue", 180, 100, 14, 28, 70, 200, 550, 750, 950);
	private static final TitleDeed NEW_YORK_AVENUE = new TitleDeed(ORANGE_MONOPOLY_DEFINITION, "New York Avenue", 200, 100, 16, 32, 80, 220, 600, 800, 1000);
	
	private static final TitleDeed KENTUCKY_AVENUE = new TitleDeed(RED_MONOPOLY_DEFINITION, "Kentucky Avenue", 220, 150, 18, 36, 90, 250, 700, 875, 1050);
	private static final TitleDeed INDIANA_AVENUE = new TitleDeed(RED_MONOPOLY_DEFINITION, "Indiana Avenue", 220, 150, 18, 36, 90, 250, 700, 875, 1050);
	private static final TitleDeed ILLINOIS_AVENUE = new TitleDeed(RED_MONOPOLY_DEFINITION, "Illinois Avenue", 250, 150, 20, 40, 100, 300, 750, 925, 1100);
	
	private static final TitleDeed ATLANTIC_AVENUE = new TitleDeed(YELLOW_MONOPOLY_DEFINITION, "Atlantic Avenue", 260, 150, 22, 44, 110, 330, 800, 975, 1150);
	private static final TitleDeed VENTNOR_AVENUE = new TitleDeed(YELLOW_MONOPOLY_DEFINITION, "Ventnor Avenue", 260, 150, 22, 44, 110, 330, 800, 975, 1150);
	private static final TitleDeed MARVIN_GARDENS = new TitleDeed(YELLOW_MONOPOLY_DEFINITION, "Marvin Gardens", 280, 150, 24, 48, 120, 360, 850, 1025, 1200);
	
	private static final TitleDeed PACIFIC_AVENUE = new TitleDeed(GREEN_MONOPOLY_DEFINITION, "Pacific Avenue", 300, 200, 26, 52, 130, 390, 900, 1100, 1275);
	private static final TitleDeed NORTH_CAROLINA_AVENUE = new TitleDeed(GREEN_MONOPOLY_DEFINITION, "North Carolina Avenue", 300, 200, 26, 52, 130, 390, 900, 1100, 1275);
	private static final TitleDeed PENNSYLVANIA_AVENUE = new TitleDeed(GREEN_MONOPOLY_DEFINITION, "Pennsylvania Avenue", 320, 200, 28, 56, 150, 450, 1000, 1200, 1400);
	
	private static final TitleDeed PARK_PLACE = new TitleDeed(BLUE_MONOPOLY_DEFINITION, "Park Place", 350, 200, 35, 70, 175, 500, 1100, 1300, 1500);
	private static final TitleDeed BOARDWALK = new TitleDeed(BLUE_MONOPOLY_DEFINITION, "Boardwalk", 400, 200, 50, 100, 200, 600, 1400, 1700, 2000);
	
	private static final List<TitleDeed> AVAILABLE_TITLE_DEEDS = new ArrayList<>();
	
	public static final Title READING_RAILROAD = new Title(RAILROADS_DEFINITION, "Reading Railroad", 200);
	private static final Title PENNSYLVANIA_RAILROAD = new Title(RAILROADS_DEFINITION, "Pennsylvania Railroad", 200);
	private static final Title B_AND_O_RAILROAD = new Title(RAILROADS_DEFINITION, "B & O Railroad", 200);
	private static final Title SHORT_LINE_RAILROAD = new Title(RAILROADS_DEFINITION, "Short Line Railroad", 200);
	
	private static final Title ELECTRIC_COMPANY_UTILITY = new Title(UTILITIES_DEFINITION, "Electric Company", 150);
	public static final Title WATER_WORKS_UTILITY = new Title(UTILITIES_DEFINITION, "Water Works", 150);
	
	static {
		AVAILABLE_TITLE_DEEDS.add(MEDITERRANEAN_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(BALTIC_AVENUE);
		
		AVAILABLE_TITLE_DEEDS.add(ORIENTAL_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(VERMONT_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(CONNECTICUT_AVENUE);
		
		AVAILABLE_TITLE_DEEDS.add(ST_CHARLES_PLACE);
		AVAILABLE_TITLE_DEEDS.add(STATES_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(VIRGINIA_AVENUE);
		
		AVAILABLE_TITLE_DEEDS.add(ST_JAMES_PLACE);
		AVAILABLE_TITLE_DEEDS.add(TENNESSEE_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(NEW_YORK_AVENUE);
		
		AVAILABLE_TITLE_DEEDS.add(KENTUCKY_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(INDIANA_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(ILLINOIS_AVENUE);
		
		AVAILABLE_TITLE_DEEDS.add(ATLANTIC_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(VENTNOR_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(MARVIN_GARDENS);
		
		AVAILABLE_TITLE_DEEDS.add(PACIFIC_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(NORTH_CAROLINA_AVENUE);
		AVAILABLE_TITLE_DEEDS.add(PENNSYLVANIA_AVENUE);
		
		AVAILABLE_TITLE_DEEDS.add(PARK_PLACE);
		AVAILABLE_TITLE_DEEDS.add(BOARDWALK);
	}

	static List<BoardSpace> createGameBoard() {
		List<BoardSpace> result = new ArrayList<>(NUM_BOARD_SPACES_TOTAL);
		result.add(new GoSpace());
		result.add(new PropertyBoardSpace(MEDITERRANEAN_AVENUE));
		result.add(new CommunityChestSpace());
		result.add(new PropertyBoardSpace(BALTIC_AVENUE));
		result.add(new IncomeTaxSpace());
		result.add(new RailroadBoardSpace(READING_RAILROAD));
		result.add(new PropertyBoardSpace(ORIENTAL_AVENUE));
		result.add(new ChanceSpace());
		result.add(new PropertyBoardSpace(VERMONT_AVENUE));
		result.add(new PropertyBoardSpace(CONNECTICUT_AVENUE));
		result.add(new JailSpace());
		result.add(new PropertyBoardSpace(ST_CHARLES_PLACE));
		result.add(new UtilityBoardSpace(ELECTRIC_COMPANY_UTILITY));
		result.add(new PropertyBoardSpace(STATES_AVENUE));
		result.add(new PropertyBoardSpace(VIRGINIA_AVENUE));
		result.add(new RailroadBoardSpace(PENNSYLVANIA_RAILROAD));
		result.add(new PropertyBoardSpace(ST_JAMES_PLACE));
		result.add(new CommunityChestSpace());
		result.add(new PropertyBoardSpace(TENNESSEE_AVENUE));
		result.add(new PropertyBoardSpace(NEW_YORK_AVENUE));
		result.add(new FreeParkingSpace());
		result.add(new PropertyBoardSpace(KENTUCKY_AVENUE));
		result.add(new ChanceSpace());
		result.add(new PropertyBoardSpace(INDIANA_AVENUE));
		result.add(new PropertyBoardSpace(ILLINOIS_AVENUE));
		result.add(new RailroadBoardSpace(B_AND_O_RAILROAD));
		result.add(new PropertyBoardSpace(ATLANTIC_AVENUE));
		result.add(new PropertyBoardSpace(VENTNOR_AVENUE));
		result.add(new UtilityBoardSpace(WATER_WORKS_UTILITY));
		result.add(new PropertyBoardSpace(MARVIN_GARDENS));
		result.add(new GoDirectlyToJailSpace());
		result.add(new PropertyBoardSpace(PACIFIC_AVENUE));
		result.add(new PropertyBoardSpace(NORTH_CAROLINA_AVENUE));
		result.add(new CommunityChestSpace());
		result.add(new PropertyBoardSpace(PENNSYLVANIA_AVENUE));
		result.add(new RailroadBoardSpace(SHORT_LINE_RAILROAD));
		result.add(new ChanceSpace());
		result.add(new PropertyBoardSpace(PARK_PLACE));
		result.add(new LuxuryTaxSpace());
		result.add(new PropertyBoardSpace(BOARDWALK));
		return result;
	}
	
	static List<TitleDeed> getAvailableTitleDeeds() {
		return AVAILABLE_TITLE_DEEDS;
	}
}