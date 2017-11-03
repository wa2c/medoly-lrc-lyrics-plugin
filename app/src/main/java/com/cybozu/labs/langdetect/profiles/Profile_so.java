package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_so extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>() {{ put("YO ",13); put("jec",34); put("jee",32); put("D",313); put("E",183); put("F",66); put("G",214); put("A",673); put("B",249); put("C",240); put("L",152); put("M",367); put("N",163); put("O",122); put("H",180); put("I",236); put("J",129); put("K",173); put("U",82); put("T",107); put("W",226); put("V",11); put("Q",76); put("P",22); put("S",486); put("R",114); put("Y",96); put("X",120); put("Z",10); put("f",458); put("g",2154); put("d",5233); put("e",4497); put("b",2102); put("c",900); put("a",24510); put("n",3878); put("o",5982); put("l",3786); put("m",2460); put("j",397); put("k",2897); put("h",3132); put("i",6615); put("w",2306); put("v",27); put("u",3829); put("t",1545); put("s",2871); put("r",2895); put("q",718); put("p",77); put("z",23); put("y",3607); put("x",1698); put("jaa",13); put("jab",16); put("jar",10); put("jam",12); put("Xam",11); put("joo",14); put("Xas",10); put("jis",14); put("jir",95); put("jii",13); put("jid",17); put("jo ",15); put("Far",12); put("isk",69); put("ism",12); put("isl",25); put("iso",22); put("isu",42); put("ist",67); put("ita",17); put("is ",71); put("ion",20); put("ir ",84); put("irs",56); put("irt",28); put("iro",22); put("irk",32); put("iri",56); put("isi",32); put("ish",96); put("ise",18); put("isb",17); put("Wux",23); put("isa",134); put("ire",16); put("ira",131); put("iyi",10); put("iyo",394); put("iya",423); put("iye",65); put("ixi",16); put(" l",598); put(" m",880); put("kii",161); put(" n",189); put(" o",537); put(" h",365); put(" i",795); put(" j",267); put(" k",1328); put(" d",1214); put(" e",328); put(" f",95); put(" g",401); put(" a",1317); put(" b",593); put(" c",361); put(" y",296); put(" x",283); put(" u",599); put(" t",376); put(" w",1834); put(" q",291); put(" p",20); put(" s",807); put(" r",112); put("km ",14); put(" J",125); put(" K",142); put(" H",119); put(" I",161); put(" N",93); put(" O",34); put(" L",81); put(" M",322); put(" B",217); put("khd",24); put(" C",229); put("kha",11); put(" A",275); put(" F",59); put(" G",169); put(" D",236); put(" E",41); put(" Z",10); put(" Y",40); put(" X",90); put(" S",438); put(" R",66); put(" Q",69); put(" P",18); put(" W",211); put(" U",33); put(" T",83); put("kee",20); put("key",11); put("kh ",38); put("Web",10); put("Waa",56); put("ku ",434); put("kor",15); put("Wax",40); put("koo",94); put("War",17); put("XEE",11); put("مد",16); put("Gal",22); put("و",25); put("ي",76); put("ف",13); put("ق",12); put("ل",77); put("م",62); put("ن",31); put("ه",13); put("د",46); put("ح",26); put("ب",37); put("ة",21); put("ا",98); put("أ",11); put("ع",29); put("ش",21); put("س",23); put("ر",49); put("kar",49); put("kas",30); put("kan",49); put("kal",143); put("kam",32); put("kad",48); put("kac",14); put("kab",10); put("kaa",81); put("ka ",1268); put("A ",83); put(" Ga",53); put(" Ge",18); put("Da",59); put("DU",11); put("Cu",18); put("Co",13); put("DE",11); put(" Fi",17); put("Ce",13); put("DH",15); put("Ci",23); put(" Ha",35); put("Du",13); put("EY",13); put(" Go",61); put(" Gu",12); put("EG",11); put("De",45); put("EE",45); put("EL",14); put("Di",29); put("Dh",36); put("H ",16); put("GA",19); put("Fa",23); put(" IY",15); put("Er",12); put(" Ho",29); put("ha ",334); put(" Hi",37); put("Ge",18); put(" Ji",25); put("Ga",53); put("حم",18); put("HA",35); put("I ",13); put(" Ja",63); put(" KA",16); put(" Is",32); put(" It",29); put("GM",12); put(" In",35); put("Fi",17); put("ham",43); put("han",102); put(" Ka",28); put("hal",48); put("haw",17); put("hax",44); put("haq",58); put(" Ki",19); put("har",45); put("has",76); put(" Kh",10); put(" Ju",19); put("hah",12); put("hab",77); put("haa",189); put("had",144); put("hac",36); put("AS",15); put("AR",23); put(" MA",17); put("AX",27); put(" La",22); put("AY",15); put("BA",11); put(" Li",11); put("C ",10); put("AD",43); put("AA",51); put("AB",14); put("AG",11); put(" Ko",23); put("AH",23); put("hay",333); put("AL",37); put(" Ku",26); put("AM",13); put("AN",35); put(" Ma",180); put("Ax",18); put("Ar",12); put("D ",22); put("بن",10); put(" Mi",27); put("Ba",101); put("CA",15); put("Af",65); put("بد",10); put("he ",25); put("Aa",22); put("Ab",33); put("Ad",10); put("Am",17); put(" Lu",25); put("Al",38); put(" Ne",14); put("Bu",30); put(" Na",32); put("Ca",127); put("DA",43); put("E ",30); put("Bi",19); put("Be",25); put("hda",27); put("Bo",30); put("Hin",18); put(" Mu",78); put("hel",22); put("Ku",26); put("hee",112); put("Ko",23); put("hey",26); put("hex",72); put("Li",11); put("N ",26); put("her",11); put("MA",41); put("La",22); put("Lu",25); put("hi ",27); put("Mi",27); put("NK",10); put("ال",51); put("O ",34); put("NA",12); put("Ma",180); put("Mu",79); put("Ne",14); put("Na",32); put(" Am",16); put(" Al",38); put("Nu",16); put(" Af",65); put("No",12); put("OO",18); put(" Ad",10); put(" Aa",22); put(" Ab",33); put(" Ba",101); put(" CA",12); put(" Ax",18); put(" Ar",12); put("hig",23); put(" Be",25); put("hid",12); put(" Bi",19); put("hin",40); put("Go",61); put("him",17); put("Gu",12); put(" Bo",30); put("hii",170); put(" Bu",30); put("his",24); put("hir",31); put("Ha",35); put(" Ca",127); put("Hi",37); put(" Ce",13); put(" DE",10); put(" Ci",23); put("IN",12); put("Ho",29); put(" DH",13); put("IS",10); put(" Co",12); put(" Cu",18); put("IY",20); put(" Da",59); put(" Di",29); put(" Dh",36); put("In",36); put(" De",45); put("Is",32); put("It",30); put("Ja",63); put("KA",33); put(" Du",13); put("Ji",25); put(" Er",12); put("Ju",19); put("LA",35); put("Ka",28); put("Kh",10); put("ho ",53); put("Har",14); put("Ki",19); put("LE",16); put(" Fa",23); put("gma",64); put("go ",32); put(" Xi",13); put(" Xa",51); put("UU",11); put("yuu",26); put(" Wu",23); put("To",11); put("Th",10); put(" Wi",15); put(" We",12); put("Ta",37); put(" Wa",133); put("St",13); put("Su",23); put("Wu",23); put("gob",97); put("Wi",16); put("Wa",133); put("XA",19); put("We",12); put("XE",12); put("Y ",18); put("yst",29); put(" Yu",14); put("yso",15); put(" Ya",10); put("WA",26); put("gmo",41); put("ysa",93); put("Qa",26); put("Qo",17); put(" م",12); put("RA",10); put("S ",18); put(" ع",21); put(" ا",48); put("goo",52); put("R ",20); put(" ب",13); put("gsa",14); put("gu ",229); put("Si",17); put("Sh",86); put("gsi",12); put("So",180); put("Ru",12); put("U ",11); put("Sa",70); put("TA",13); put("Re",13); put("SH",11); put("Ro",11); put("yoo",24); put("Qu",16); put("SA",16); put("Ra",20); put("gud",22); put(" Nu",16); put(" No",12); put("gta",43); put(" Ra",20); put(" Qu",16); put("b ",130); put(" Ro",11); put(" Re",13); put("guu",20); put("gun",12); put("a ",5909); put(" Qo",17); put(" Qa",26); put("شي",10); put(" Su",23); put(" St",13); put(" Ta",37); put("Ya",10); put(" Th",10); put("Yu",14); put(" To",11); put(" Ru",12); put(" Sa",70); put("Xa",51); put("YO",15); put(" Sh",86); put(" Si",17); put("Xi",13); put(" So",180); put(" WA",20); put("ري",12); put("Gob",48); put(" ja",60); put("i ",853); put("ye ",36); put("ian",11); put(" iy",365); put(" ji",127); put("ge",93); put(" je",47); put("ga",1135); put("fk",16); put("Ing",16); put(" im",15); put(" in",148); put(" il",54); put(" ii",23); put("ic ",14); put("fi",49); put("fr",45); put("fu",47); put("ft",29); put("fo",18); put(" is",155); put(" ka",688); put(" kh",13); put("hd",44); put("he",286); put(" ki",46); put(" ke",11); put("ha",1580); put("gn",11); put("gm",108); put(" jo",14); put("gl",15); put("gi",72); put("id ",171); put("gu",305); put("iba",32); put("gt",52); put("gs",27); put("gr",15); put(" ju",17); put("go",196); put("du",188); put("dw",36); put("dy",13); put("g ",83); put(" ha",190); put("ea",16); put("eb",72); put("yee",61); put("ec",51); put(" he",28); put("ed",360); put("de",252); put("dd",113); put("di",494); put("dh",632); put("dk",189); put("dl",33); put(" go",117); put("do",234); put("dn",22); put(" gu",55); put("ia ",36); put("ex",102); put("ey",554); put("fa",110); put("h ",441); put(" id",15); put("fe",17); put("eh",54); put("ib ",32); put("eg",202); put(" hi",20); put("ee",1263); put("el",242); put("ek",35); put(" ho",120); put("ei",12); put("yey",26); put("en",172); put("em",31); put("et",26); put("es",93); put("er",287); put("ya ",266); put("ca",427); put(" ni",37); put("e ",881); put(" ne",15); put("bs",21); put(" na",54); put("br",36); put("bu",104); put("bt",55); put("bn",18); put("bo",234); put("bk",30); put("bl",13); put(" mu",48); put("ig ",10); put("bi",355); put("bb",15); put("bd",41); put("be",201); put("db",11); put("da",2087); put(" og",18); put("f ",98); put("cy",18); put(" of",16); put("cu",41); put("ct",11); put("cs",27); put("co",62); put("cm",24); put("cn",13); put("cl",19); put("ci",73); put(" nu",10); put("ch",33); put(" no",73); put("ce",64); put("cd",20); put("yad",111); put("yag",10); put(" le",91); put("c ",51); put("yaa",287); put(" la",334); put("icm",22); put(" ku",465); put("ici",14); put(" km",14); put("ica",25); put(" ko",88); put(" me",49); put("az",10); put("ay",1458); put("idu",13); put(" mi",187); put("ba",817); put("d ",893); put("at",134); put("as",580); put("yd ",29); put("ido",43); put("ar",1307); put("aq",237); put(" ma",590); put("ax",1066); put("aw",157); put("idk",12); put("yay",52); put(" lu",25); put("ak",76); put("al",1647); put("idi",35); put("yaw",11); put("idh",19); put("ai",29); put("aj",59); put("yar",45); put("am",590); put("an",1951); put("yaq",50); put("yan",13); put("ac",260); put("ida",140); put("ad",2243); put("aa",4171); put(" lo",138); put("ab",630); put("ag",664); put("ah",1152); put("yah",134); put("af",128); put("iib",15); put("nu",38); put("iic",11); put("nt",263); put(" af",45); put("ns",59); put(" ah",473); put(" aa",208); put("iig",13); put(" ab",31); put("iid",50); put("no",160); put("nn",18); put(" ad",49); put("q ",34); put(" am",103); put(" an",18); put("iik",48); put("iin",164); put("ny",57); put("yka",17); put("iil",93); put(" al",21); put("iim",26); put("iis",199); put("iir",65); put("of",78); put("iiq",14); put("oc",29); put(" ax",10); put("od",156); put(" ar",26); put("ob",291); put(" aq",21); put(" as",29); put("om",340); put("on",186); put(" ba",344); put("ok",16); put("ol",273); put(" ay",246); put("og",129); put("il ",80); put("ot",41); put("os",90); put(" bi",107); put("op",10); put("oo",1738); put(" be",63); put("or",236); put("oq",49); put("yn ",105); put(" bo",34); put("r ",475); put("ox",10); put("ow",125); put("oy",128); put(" bu",35); put("pa",14); put(" ca",238); put("im ",21); put("ika",50); put("lo",386); put("ige",10); put("lm",39); put("ll",110); put("ls",27); put("iga",247); put("ii ",339); put("lw",14); put("lu",48); put("igi",31); put("yo ",488); put("ly",56); put("igu",13); put("igt",12); put("o ",2012); put("ma",1465); put("mb",52); put("mh",21); put("me",199); put("mk",39); put("mi",333); put("mp",19); put("mo",102); put("yna",98); put("mu",85); put("ihi",82); put("yni",14); put("na",851); put("nb",30); put("yne",30); put("nc",10); put("nd",137); put("ne",107); put("nf",30); put("ng",58); put("ynt",29); put("ni",213); put("nk",312); put("nl",21); put("imo",20); put("ju",17); put("jo",31); put(" ee",295); put("imi",21); put("ki",203); put("kh",95); put("ke",48); put("ind",29); put("ina",80); put(" fa",48); put("yga",15); put("ka",1778); put("yi ",19); put("m ",103); put(" fu",10); put("ino",13); put("kt",20); put(" fo",12); put("ku",558); put("int",102); put("ins",10); put("ko",130); put("ine",14); put("ing",16); put(" fi",17); put("ini",10); put("km",16); put("ink",82); put(" ge",36); put("li",577); put("lk",332); put("le",352); put(" ga",186); put("ld",23); put("lg",22); put("inu",15); put("la",1306); put("lb",52); put("iny",13); put("n ",1478); put(" co",22); put("ht",11); put("hu",92); put("ikh",54); put(" ce",15); put("hi",387); put("hn",16); put("ho",217); put(" ci",36); put("ila",160); put("id",471); put("ic",103); put("yin",59); put("ib",108); put("ia",61); put("ih",88); put("in ",262); put("ig",350); put(" da",424); put("if",21); put("yih",49); put("yig",21); put(" cu",34); put("hy",12); put("k ",24); put("iq",21); put(" do",45); put("ilo",13); put("ir",438); put("is",630); put("it",49); put("ill",18); put("ilk",32); put("ix",28); put("ilm",12); put("ii",1062); put("ij",21); put("ik",134); put(" de",120); put("ili",51); put("il",385); put("im",170); put("in",663); put("io",30); put(" di",70); put("yir",13); put(" dh",511); put("ima",76); put("je",69); put("ji",178); put("iy",896); put(" du",39); put("l ",398); put("ja",82); put("xi",123); put("xo",56); put("xm",34); put("xw",27); put("xu",185); put("xb",18); put("xa",850); put("xe",161); put("xd",67); put("wg",11); put("wi",81); put("how",15); put("wl",60); put("wo",26); put("wu",102); put("hog",13); put("y ",1137); put("wa",1722); put("wd",13); put("hoo",55); put("we",185); put("hor",60); put(" yi",55); put(" yu",13); put("uy",12); put("ux",164); put("uw",34); put("uu",720); put(" ye",13); put("ve",10); put(" ya",211); put("x ",140); put(" xo",33); put("uj",15); put("uk",28); put("ul",200); put("uf",20); put(" xi",90); put("ug",210); put("uh",16); put("uq",90); put("ur",259); put("hna",12); put(" xu",39); put("us",114); put("ut",54); put("um",90); put("un",214); put("tu",47); put("ub",104); put("ua",11); put("ud",145); put("uc",17); put(" xe",16); put("w ",59); put(" xa",103); put("to",175); put("hul",37); put("tr",25); put("te",120); put("ti",246); put("th",37); put("ta",784); put("su",111); put("ss",19); put("st",173); put("sw",12); put("sl",47); put("sk",106); put("sm",25); put("so",371); put("sr",10); put("sc",17); put("se",101); put("sh",456); put("ي ",20); put("xme",19); put("si",404); put("xma",13); put("u ",1296); put("sa",722); put("sb",21); put("rr",20); put("rs",115); put("rt",160); put("ru",77); put("rw",11); put("rx",11); put("ry",27); put("ro",144); put("rn",40); put("rm",32); put("rl",22); put("rk",200); put("ri",397); put("hu ",11); put("rg",35); put("re",258); put("rd",49); put("rc",12); put("rb",25); put("ra",754); put("t ",51); put("qu",35); put("qs",10); put("xoo",44); put("qo",163); put("IYO",15); put("qi",33); put("qe",23); put("qa",334); put("qd",61); put("s ",240); put("pu",15); put("pr",14); put(" ru",12); put(" u ",194); put(" sa",221); put(" se",17); put(" si",157); put(" sh",112); put(" so",259); put(" qu",21); put("xya",13); put(" ra",48); put(" re",33); put("ن ",17); put(" ro",11); put(" qe",14); put(" qa",168); put(" qo",69); put(" qi",18); put(" oo",464); put(" or",10); put("huu",29); put(" wa",1582); put(" we",88); put(" wo",12); put(" wu",102); put(" wi",39); put(" uu",195); put("xud",12); put("xuu",133); put("Hoo",12); put(" tu",36); put(" us",16); put(" ur",10); put("م ",11); put(" um",12); put(" un",11); put(" ug",131); put("yg",19); put(" ta",231); put("ye",133); put("yd",48); put("ya",998); put("yb",27); put("xwe",21); put("xy",17); put(" su",25); put("yu",34); put("ys",166); put(" to",18); put(" th",15); put(" ti",62); put("yo",522); put("yn",280); put(" te",11); put("yk",19); put("yi",189); put("fee",11); put("xey",58); put("xee",54); put("far",32); put("fad",21); put("faa",24); put("Suu",12); put("Axm",14); put("xir",17); put("xis",13); put("xil",26); put("xii",17); put("xid",14); put("xig",24); put("Sta",10); put("xa ",169); put("eyb",17); put("eya",63); put("eys",74); put("Tal",11); put("eyn",163); put("eyo",14); put("eyk",10); put("xda",51); put("eyd",16); put("eye",14); put("exa",10); put("exd",12); put("exe",51); put("xe ",46); put("xar",38); put("Ban",18); put("Baa",14); put("Bad",22); put("xam",54); put("xan",16); put("Bar",23); put("xay",166); put("xba",16); put("xaa",341); put("xad",27); put("xag",13); put("wux",100); put("Aas",11); put("Shi",22); put("She",12); put("Sha",50); put("ex ",21); put("Af ",19); put("ey ",159); put("er ",103); put("es ",21); put("eri",33); put("ere",30); put("era",49); put("Afr",32); put("esh",28); put("esa",10); put("ers",11); put("ern",14); put("ekh",16); put("en ",89); put("ela",47); put("ele",26); put("eli",17); put("ell",42); put("elo",15); put("emb",19); put("ena",28); put("wla",53); put("eny",12); put("egm",90); put("ego",14); put("egt",11); put("Som",32); put("Soo",136); put("woq",10); put("el ",65); put("wda",13); put("Buu",11); put("Bur",11); put("we ",12); put("gir",17); put("gii",26); put("wey",124); put("wee",27); put("gey",15); put("gee",44); put("wi ",14); put("wis",10); put("wii",22); put("Sal",11); put("gab",12); put("gac",45); put("gad",26); put("DA ",20); put("gaa",436); put("gar",35); put("gay",21); put("gal",70); put("gan",69); put("ga ",388); put("San",27); put("wa ",22); put("Cab",27); put("waq",26); put("wan",30); put("wal",39); put("wax",715); put("way",45); put("Cal",18); put("war",52); put("was",18); put("Car",40); put("waa",581); put("wad",168); put("Bel",10); put("fur",37); put("Bis",12); put("fri",39); put("fii",15); put("Boo",10); put("fka",13); put("da ",918); put("de ",22); put("dad",131); put("daa",159); put("dab",19); put("dal",113); put("WAX",16); put("dag",65); put("dah",101); put("dar",51); put("dan",291); put("dam",39); put("day",61); put("dax",79); put("daw",32); put("Cum",10); put("dda",74); put("dde",11); put("ddi",17); put("cun",14); put("EEY",13); put("EEL",14); put("EGM",11); put("Deg",30); put("cyo",15); put("uxu",126); put("Daa",22); put("Dag",10); put("Dal",10); put("uxa",15); put("uun",88); put("uul",63); put("uum",13); put("uug",15); put("uud",50); put("uux",10); put("ux ",12); put("uus",29); put("uur",74); put("uuq",18); put("uut",24); put("uwa",28); put("co ",26); put("cma",23); put("ush",13); put("usi",11); put("use",13); put("uu ",316); put("usu",26); put("uso",11); put("uti",16); put("uta",19); put("cod",10); put("com",11); put("uqa",33); put("uqd",36); put("ura",37); put("ure",10); put("uri",31); put("urk",17); put("urt",32); put("uru",37); put("ur ",39); put("csi",14); put("uma",56); put("unt",32); put("unk",27); put("uni",11); put("una",85); put("cel",30); put("uka",13); put("cee",17); put("uls",10); put("ulo",20); put("ull",14); put("ulk",27); put("uli",14); put("ule",16); put("ula",26); put("un ",29); put("che",12); put("ul ",36); put("ciy",12); put("cii",28); put("uga",40); put("ugu",128); put("ugs",11); put("ed ",184); put("ebi",20); put("uf ",13); put("uda",33); put("udi",12); put("eb ",12); put("udu",37); put("ug ",18); put("ega",53); put("ub ",32); put("eek",25); put("een",99); put("eel",138); put("eem",18); put("eeb",23); put("eeg",65); put("eed",229); put("eey",113); put("eh ",42); put("ees",56); put("eer",157); put("edk",18); put("edi",12); put("ede",22); put("eda",72); put("uba",39); put("ubb",11); put("edu",15); put("ud ",36); put("edo",11); put("ecl",12); put("ece",25); put("ee ",319); put("dwe",25); put("dwa",11); put("duu",57); put("tuu",22); put("doo",96); put("dow",37); put("tri",10); put("The",10); put("dna",12); put("to ",75); put("Dhe",14); put("Dhu",12); put("dun",12); put("dul",20); put("dug",23); put("too",69); put("du ",45); put("tii",59); put("tig",10); put("tir",66); put("dha",335); put("tio",16); put("tic",26); put("dhu",33); put("dib",25); put("dhi",112); put("dhe",122); put("dho",21); put("der",19); put("dex",18); put("dey",16); put("dee",48); put("deg",96); put("den",15); put("di ",38); put("dle",11); put("dla",17); put("tee",36); put("dku",14); put("dki",33); put("do ",77); put("ter",36); put("diy",39); put("din",26); put("ti ",29); put("dir",60); put("dis",51); put("dig",42); put("dii",165); put("dil",12); put("dka",134); put("the",16); put("rga",14); put("ri ",48); put("rge",14); put("rey",42); put("ree",110); put("rda",15); put("rdh",16); put("re ",77); put("rco",10); put("rax",25); put("ray",99); put("rar",15); put("ras",44); put("rat",10); put("rba",11); put("rah",41); put("ran",54); put("ram",17); put("rak",12); put("rab",82); put("raa",165); put("rad",87); put("rs ",11); put("roo",48); put("rna",16); put("rne",11); put("rni",10); put("ro ",63); put("rma",23); put("Nab",15); put("rla",13); put("rku",10); put("rko",10); put("rki",41); put("rke",18); put("rka",117); put("riy",58); put("ris",28); put("rig",31); put("rii",110); put("rik",46); put("rin",21); put("ric",16); put("rya",13); put("rur",10); put("run",18); put("ruu",10); put("ry ",11); put("rsi",16); put("rsa",63); put("rsh",15); put("rta",110); put("rto",18); put("rte",11); put("rti",11); put("rub",12); put("saa",120); put("sab",11); put("sad",52); put("sag",23); put("sah",11); put("sal",49); put("sam",47); put("sbi",14); put("san",191); put("sas",14); put("sar",33); put("say",43); put("sa ",99); put("sha",242); put("sho",46); put("she",41); put("shi",83); put("si ",68); put("siy",42); put("sid",91); put("shu",10); put("sil",13); put("sim",38); put("sii",82); put("sig",32); put("se ",61); put("sh ",17); put("see",14); put("sow",16); put("som",59); put("soo",214); put("soc",14); put("su ",25); put("sla",30); put("sku",37); put("ska",59); put("so ",55); put("sma",15); put("حمد",15); put("ste",15); put("sta",66); put("sto",28); put("sti",41); put("sub",11); put("suf",12); put("sug",13); put("sul",11); put("suu",22); put("tal",42); put("tag",10); put("tah",87); put("taa",194); put("tad",13); put("tay",60); put("tar",33); put("tan",31); put("tam",13); put("te ",13); put("ta ",272); put("bka",23); put("biy",71); put("bis",28); put("bir",12); put("bil",48); put("bin",31); put("big",38); put("bii",37); put("bo ",47); put("bol",129); put("bna",15); put("boo",24); put("bba",12); put("be ",19); put("ban",61); put("bal",43); put("bah",27); put("bad",232); put("baa",96); put("bab",12); put("bay",35); put("bax",34); put("bas",10); put("bar",156); put("bdi",25); put("bdu",11); put("bi ",69); put("bee",145); put("ber",11); put("bey",12); put("ca ",55); put("car",35); put("cas",13); put("can",24); put("cay",13); put("cab",20); put("cad",53); put("caa",145); put("cal",33); put("cag",16); put("bri",13); put("bra",15); put("bsa",11); put("bta",33); put("bti",13); put("bur",20); put("bul",12); put("buu",52); put("aka",19); put("am ",40); put("aki",23); put("aji",27); put("ajo",16); put("qa ",12); put("al ",136); put("ahi",41); put("qar",20); put("qay",16); put("aho",10); put("qad",44); put("qab",47); put("qaa",149); put("ahd",20); put("qan",14); put("qal",17); put("ahe",26); put("aha",697); put("agm",13); put("agt",24); put("agu",76); put("ago",29); put("aq ",22); put("qdi",38); put("qda",17); put("any",23); put("ano",51); put("ann",10); put("ant",70); put("ans",32); put("ane",21); put("ang",10); put(" ال",46); put("ani",87); put("ank",185); put("ana",385); put("anb",26); put("and",92); put("amu",23); put("amo",10); put("amk",32); put("amh",19); put("ami",82); put("ame",93); put("amb",16); put("ama",257); put("aly",20); put("qey",14); put("alo",160); put("alm",17); put("all",22); put("alk",165); put("alg",17); put("ali",424); put("ald",14); put("ale",110); put("ala",480); put("alb",42); put("an ",924); put("aba",194); put("abd",37); put("abe",56); put("abi",146); put("abk",18); put("abo",40); put("abt",38); put("abu",36); put("aca",130); put("aab",114); put("aac",13); put("aaa",15); put("aaf",38); put("aag",64); put("aad",398); put("aaj",28); put("aak",21); put("aah",75); put("aan",742); put("aal",743); put("aam",113); put("aas",211); put("aar",259); put("aaq",41); put("aaw",32); put("aat",37); put("aay",89); put("aax",19); put("ad ",334); put("qiy",15); put("ac ",19); put("aa ",1110); put("qii",10); put("ab ",33); put("afr",11); put("aft",15); put("afi",18); put("aga",458); put("age",12); put("ah ",325); put("afa",38); put("ado",85); put("adl",23); put("adk",153); put("adn",12); put("adh",26); put("adi",223); put("add",96); put("ade",66); put("ag ",29); put("adw",22); put("adu",44); put("aci",16); put("ace",10); put("Qar",12); put("acd",15); put("ada",1138); put("af ",19); put("acy",15); put("acs",19); put("qor",48); put("qoo",60); put("qof",24); put("axi",13); put("axm",15); put("axo",15); put("axu",15); put("axa",702); put("axb",16); put("axd",50); put("axe",90); put("ayi",11); put("ayo",52); put("ayn",115); put("ays",84); put("ayu",13); put("axy",16); put("axw",26); put("ayb",10); put("aya",151); put("ayg",11); put("ayd",32); put("aye",26); put("ba ",84); put("qur",24); put("at ",11); put("arg",25); put("are",96); put("ard",30); put("arb",14); put("ara",357); put("aro",72); put("arn",19); put("arm",17); put("arl",10); put("ark",135); put("ari",153); put("aru",20); put("ars",39); put("art",72); put("asa",99); put("ary",14); put("asi",106); put("ash",156); put("ase",12); put("aso",31); put("ask",17); put("ar ",198); put("as ",80); put("aqa",111); put("aqi",13); put("aqo",51); put("ax ",98); put("awe",20); put("ay ",932); put("awa",46); put("awl",31); put("awi",33); put("ata",37); put("asu",12); put("ast",33); put("ato",18); put("ate",17); put("ra ",58); put("ati",34); put("ngi",20); put("ni ",47); put("Isl",11); put("neh",11); put("ng ",11); put("nee",16); put("nfu",25); put("ney",14); put("ne ",43); put("ndh",18); put("ndi",22); put("nan",17); put("nac",45); put("nad",83); put("nah",41); put("nab",18); put("naa",131); put("Ito",28); put("nbe",15); put("nd ",69); put("AXE",10); put("AY ",10); put("nba",11); put("AXA",12); put("nay",47); put("nax",11); put("na ",412); put("Jab",13); put("Jan",13); put("Jam",22); put("KA ",11); put("KAL",10); put("nya",38); put("AAL",13); put("ADA",25); put("nuu",21); put("nto",13); put("nti",37); put("nta",176); put("nte",24); put("nsi",15); put("nsa",22); put("AHA",14); put("noo",67); put("noq",18); put("nna",11); put("ALA",17); put("nle",12); put("no ",59); put("nki",22); put("nka",271); put("AN ",16); put("nii",13); put("nih",11); put("nig",39); put("niy",10); put("nis",15); put("nim",17); put("nin",39); put("ogu",24); put("oga",60); put("Jub",11); put("ol ",60); put("oco",11); put("odi",15); put("of ",38); put("oda",43); put("ofe",10); put("LA ",12); put("د ",29); put("oba",86); put("od ",60); put("obo",134); put("obi",38); put("ة ",21); put("oyi",94); put("oya",10); put("owl",29); put("ow ",45); put("ost",14); put("ota",10); put("ose",28); put("os ",15); put("oon",114); put("ool",98); put("oom",198); put("oof",13); put("oog",60); put("ood",123); put("oob",124); put("or ",39); put("ooy",111); put("oow",16); put("oot",14); put("oos",65); put("oor",31); put("Koo",13); put("ore",44); put("ori",14); put("osa",11); put("ort",21); put("oqo",37); put("oqd",11); put("ora",61); put("ola",52); put("on ",52); put("olk",99); put("ole",20); put("olo",14); put("oly",10); put("ona",28); put("onf",25); put("oni",16); put("onk",11); put("ons",12); put("ont",14); put("oma",298); put("oo ",749); put("omp",12); put("la ",241); put("le ",159); put("laa",281); put("lab",61); put("lac",11); put("lad",232); put("laf",10); put("lah",96); put("lag",116); put("lal",23); put("lan",88); put("lam",27); put("las",21); put("lay",70); put("lba",15); put("lbe",31); put("kuw",22); put("kuu",18); put("kun",22); put("kul",14); put("kto",17); put("MAD",13); put("lom",11); put("loo",176); put("lmo",12); put("lmi",13); put("lma",10); put("lsh",13); put("Luu",11); put("li ",92); put("lga",16); put("ley",29); put("leh",35); put("lee",98); put("lo ",165); put("lla",49); put("lle",32); put("lka",311); put("lki",14); put("lis",19); put("lin",48); put("lim",15); put("liy",204); put("lid",28); put("lia",24); put("lib",24); put("lil",40); put("lii",17); put("lig",30); put("ma ",133); put("maa",361); put("mac",36); put("mah",24); put("mad",229); put("mag",226); put("mar",193); put("mas",14); put("mal",133); put("man",32); put("may",23); put("max",25); put("mba",26); put("mbe",10); put("me ",19); put("med",68); put("mee",72); put("mey",24); put("luq",12); put("luu",17); put("مد ",15); put("lya",33); put("lyo",10); put("Mar",22); put("Mas",10); put("Mag",51); put("Mad",20); put("Maa",17); put("Max",25); put("moo",35); put("muq",17); put("muu",16); put("mul",10); put("Mux",13); put("mhu",20); put("Muq",24); put("Mud",14); put("mi ",19); put("min",17); put("mil",14); put("mis",11); put("miy",27); put("mig",18); put("mid",170); put("mij",10); put("mii",25); put("mo ",60); put("mka",33); }};
    private static final int[] n_words_s = {94077,109135,83288};
    private static final String name_s = "so";

    public Profile_so() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
