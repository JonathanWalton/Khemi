package mithrandirr.khemi.api.element;

import java.util.HashMap;
import java.util.Map;

public class Elements {
	
	public static final Map<String, String> elements = new HashMap<>();
	
	public static void init() {
		addElements();
	}
	
	private static void addElements() {
		addElement("Hydrogen","H");
		addElement("Helium","He");
		addElement("Lithium","Li");
		addElement("Beryllium","Be");
		addElement("Boron","B");
		addElement("Carbon","C");
		addElement("Nitrogen","N");
		addElement("Oxygen","O");
		addElement("Fluorine","F");
		addElement("Neon","Ne");
		addElement("Sodium","Na");
		addElement("Magnesium","Mg");
		addElement("Aluminum","Al");
		addElement("Silicon","Si");
		addElement("Phosphorus","P");
		addElement("Sulfur","S");
		addElement("Chlorine","Cl");
		addElement("Argon","Ar");
		addElement("Potassium","K");
		addElement("Calcium","Ca");
		addElement("Scandium","Sc");
		addElement("Titanium","Ti");
		addElement("Vanadium","V");
		addElement("Chromium","Cr");
		addElement("Manganese","Mn");
		addElement("Iron","Fe");
		addElement("Cobalt","Co");
		addElement("Nickel","Ni");
		addElement("Copper","Cu");
		addElement("Zinc","Zn");
		addElement("Gallium","Ga");
		addElement("Germanium","Ge");
		addElement("Arsenic","As");
		addElement("Selenium","Se");
		addElement("Bromine","Br");
		addElement("Krypton","Kr");
		addElement("Rubidium","Rb");
		addElement("Strontium","Sr");
		addElement("Yttrium","Y");
		addElement("Zirconium","Zr");
		addElement("Niobium","Nb");
		addElement("Molybdenum","Mo");
		addElement("Technetium","Tc");
		addElement("Ruthenium","Ru");
		addElement("Rhodium","Rh");
		addElement("Palladium","Pd");
		addElement("Silver","Ag");
		addElement("Cadmium","Cd");
		addElement("Indium","In");
		addElement("Tin","Sn");
		addElement("Antimony","Sb");
		addElement("Tellurium","Te");
		addElement("Iodine","I");
		addElement("Xenon","Xe");
		addElement("Cesium","Cs");
		addElement("Barium","Ba");
		addElement("Lanthanum","La");
		addElement("Cerium","Ce");
		addElement("Praseodymium","Pr");
		addElement("Neodymium","Nd");
		addElement("Promethium","Pm");
		addElement("Samarium","Sm");
		addElement("Europium","Eu");
		addElement("Gadolinium","Gd");
		addElement("Terbium","Tb");
		addElement("Dysprosium","Dy");
		addElement("Holmium","Ho");
		addElement("Erbium","Er");
		addElement("Thulium","Tm");
		addElement("Ytterbium","Yb");
		addElement("Lutetium","Lu");
		addElement("Hafnium","Hf");
		addElement("Tantalum","Ta");
		addElement("Tungsten","W");
		addElement("Rhenium","Re");
		addElement("Osmium","Os");
		addElement("Iridium","Ir");
		addElement("Platinum","Pt");
		addElement("Gold","Au");
		addElement("Mercury","Hg");
		addElement("Thallium","Tl");
		addElement("Lead","Pb");
		addElement("Bismuth","Bi");
		addElement("Polonium","Po");
		addElement("Astatine","At");
		addElement("Radon","Rn");
		addElement("Francium","Fr");
		addElement("Actinium","Ac");
		addElement("Thorium","Th");
		addElement("Protactinium","Pa");
		addElement("Uranium","U");
		addElement("Neptunium","Np");
		addElement("Plutonium","Pu");
		addElement("Americium","Am");
		addElement("Curium","Cm");
		addElement("Berkelium","Bk");
		addElement("Californium","Cf");
		addElement("Einsteinium","Es");
		addElement("Fermium","Fm");
		addElement("Mendelevium","Md");
		addElement("Nobelium","No");
		addElement("Lawrencium","Lr");
		addElement("Rutherfordium","Rf");
		addElement("Dubnium","Db");
		addElement("Seaborgium","Sg");
		addElement("Bohrium","Bh");
		addElement("Hassium","Hs");
		addElement("Meitnerium","Mt");
		addElement("Darmstadtium","Ds");
		addElement("Roentgenium","Rg");
		addElement("Copernicium","Cn");
		addElement("Nihonium","Nh");
		addElement("Flerovium","Fl");
		addElement("Moscovium","Mc");
		addElement("Livermorium","Lv");
		addElement("Tennessine","Ts");
		addElement("Oganesson","Og");
	}
	
	private static void addElement(String element, String symbol) {
		elements.put(element, symbol);
	}

}