package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_tl extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>(1873) {{ put("D",3787); put("E",3422); put("F",1488); put("G",3274); put("A",19564); put("B",7360); put("C",4965); put("L",4772); put("M",7066); put("N",4375); put("O",1801); put("H",3508); put("I",8185); put("J",1743); put("K",5752); put("U",1449); put("T",5401); put("W",1008); put("V",1273); put("Q",420); put("P",11919); put("S",10977); put("R",3177); put("Y",471); put("X",334); put("Z",463); put("f",2669); put("g",178562); put("d",29955); put("e",64572); put("b",36938); put("c",9968); put("a",433329); put("n",268000); put("o",112013); put("l",93919); put("m",59846); put("j",824); put("k",54159); put("h",28813); put("i",161924); put("w",15439); put("v",3263); put("u",56864); put("t",84874); put("s",113569); put("r",58943); put("q",542); put("p",56795); put("z",2158); put("y",61992); put("x",703); put("Fil",231); put("í",225); put("é",238); put("á",213); put("ü",252); put("ā",268); put("Est",484); put("Eng",311); put("Ene",272); put(" l",8609); put(" m",26008); put(" n",63523); put(" o",8411); put(" h",4923); put(" i",23816); put(" k",20018); put(" d",6208); put(" e",1886); put(" f",514); put(" g",3652); put(" a",41230); put(" b",12249); put(" c",1285); put(" y",708); put(" u",3275); put(" t",9124); put(" w",1107); put(" v",245); put(" p",25524); put(" s",37805); put(" r",2505); put(" J",1713); put(" K",5573); put(" H",3377); put(" I",7706); put(" N",3834); put(" O",1616); put(" L",4623); put(" M",6813); put(" B",6692); put(" C",4389); put(" A",18851); put(" F",1372); put(" G",3134); put(" D",3532); put(" E",3171); put(" Z",430); put(" Y",427); put(" X",260); put(" S",10261); put(" R",2927); put(" Q",408); put(" P",11641); put(" W",933); put(" V",1041); put(" U",1379); put(" T",5149); put("ا",230); put("A ",369); put("Da",1003); put("Co",1457); put("Ce",320); put("Ch",481); put("Do",225); put("De",356); put("Di",1582); put("Fe",231); put("Eu",252); put("Es",754); put("En",687); put("Em",287); put("Ge",222); put("Ga",499); put("I ",336); put("Fr",271); put("Fi",327); put("C ",400); put("Au",300); put("Ar",695); put("As",627); put("Ba",3221); put("Ay",1525); put("Ag",601); put("BC",219); put("Ab",447); put("Ad",339); put("Am",736); put("BN",257); put("An",10961); put("Ap",381); put("Ak",282); put("Al",957); put("Bu",508); put("Br",412); put("Ca",1287); put("Bi",744); put("Be",555); put("Bo",628); put("Hil",266); put("Ku",269); put("Kr",232); put("Ko",739); put("Le",701); put("Li",502); put("N ",411); put("La",1279); put("Lu",1605); put("Lo",364); put("Me",527); put("Mi",786); put("Ma",4128); put("Mu",386); put("Mo",519); put("Ni",284); put("Ne",669); put("Na",1605); put("No",859); put("Ok",212); put("Ol",246); put("Gi",363); put("Gr",1131); put("Go",284); put("Gu",257); put("Ha",926); put("He",607); put("Hi",663); put("Ho",302); put("Hu",700); put("Im",288); put("In",3099); put("Ik",390); put("Il",402); put("Is",900); put("It",1478); put("Ir",258); put("Ja",583); put("Jo",504); put("Ju",288); put("Ka",3627); put("Hap",403); put("Ki",336); put("Un",1045); put("Tu",257); put("Tr",725); put("Ts",305); put("To",291); put("Th",568); put("Ti",1025); put("Te",370); put("Ta",1438); put("St",601); put("Su",844); put("Wi",302); put("Wa",226); put("Vi",399); put("Va",226); put("Pu",319); put("Pr",784); put("S ",239); put("Pe",753); put("Pa",3232); put("Po",515); put("Pi",5199); put("Ph",519); put("Or",329); put("Se",751); put("Sc",225); put("Si",3949); put("Sh",296); put("So",479); put("Sa",2369); put("Re",1018); put("Ri",307); put("Ro",908); put("Qu",349); put("Ra",347); put("Gre",522); put("Gri",303); put("b ",919); put("a ",94136); put("Sü",216); put("Za",253); put("i ",12212); put("gd",846); put("ge",1642); put("ga",29192); put("gb",804); put("Ing",2213); put("fi",306); put("fo",309); put("gy",549); put("he",2166); put("ha",12797); put("gn",612); put("gm",735); put("gl",3792); put("gk",3515); put("gi",5586); put("gh",1271); put("gg",2300); put("gu",3141); put("gt",1399); put("gs",3014); put("gr",1126); put("gp",2172); put("go",3120); put("dt",243); put("du",1243); put("dy",626); put("g ",113439); put("ea",1899); put("eb",1161); put("ec",685); put("ed",1334); put("de",3129); put("di",5171); put("do",3993); put("Ilo",317); put("dr",607); put("ew",354); put("ex",243); put("eu",223); put("ev",449); put("ey",804); put("ez",509); put("fa",228); put("h ",1453); put("Ind",341); put("fe",234); put("eh",1900); put("eg",2092); put("ee",503); put("el",4423); put("ek",1455); put("ei",449); put("ep",1032); put("eo",1328); put("Imp",228); put("en",9846); put("em",2892); put("et",2497); put("es",7771); put("er",9807); put("ca",1369); put("Ika",371); put("e ",10545); put("by",545); put("br",2325); put("bu",3483); put("bo",2508); put("bl",1265); put("bi",7420); put("be",1655); put("da",7330); put("f ",892); put("cu",348); put("ct",832); put("cr",267); put("co",1527); put("ck",419); put("ci",1114); put("ch",1408); put("ce",1134); put("cc",244); put("c ",679); put("az",285); put("ay",33855); put("ba",16262); put("d ",6470); put("at",29146); put("as",20781); put("ar",16773); put("aw",10001); put("av",702); put("au",1712); put("ak",11317); put("al",29791); put("ai",3152); put("ao",3807); put("ap",8378); put("am",13495); put("an",101085); put("ac",1440); put("ad",5449); put("aa",5389); put("ab",8765); put("ag",22898); put("ah",9461); put("ae",824); put("nu",2551); put("nt",6347); put("ns",5167); put("no",9894); put("nn",491); put("ny",2397); put("of",922); put("oc",711); put("od",3388); put("oa",467); put("ob",1692); put("om",3049); put("on",28949); put("ok",1666); put("ol",5417); put("oi",423); put("og",2491); put("oh",829); put("ot",1896); put("os",4877); put("ov",562); put("ou",1121); put("op",3555); put("oo",5633); put("or",6366); put("r ",5313); put("ow",489); put("oy",1082); put("pe",2826); put("pa",25955); put("pl",758); put("po",5042); put("ph",416); put("pi",11096); put("lo",7059); put("lm",376); put("ll",2040); put("ls",232); put("lp",216); put("lu",4808); put("lt",766); put("ly",1884); put("o ",35938); put("ma",23630); put("mb",3361); put("mg",9391); put("me",3130); put("mi",5214); put("mm",511); put("mp",3371); put("mo",2915); put("mu",4995); put("p ",2357); put("na",50921); put("nc",944); put("nd",5861); put("ne",3717); put("ng",124226); put("ni",11322); put("nl",1083); put("ki",5108); put("kh",660); put("ke",653); put("kb",240); put("ka",28062); put("m ",2592); put("ky",234); put("ks",1102); put("kt",1232); put("ku",3832); put("ko",5455); put("kr",397); put("kl",2445); put("li",16771); put("le",7298); put("ld",536); put("la",41710); put("lb",521); put("n ",41545); put("hr",229); put("hu",1485); put("hi",7425); put("hn",275); put("ho",2024); put("id",2936); put("ic",2306); put("ib",3763); put("ia",4281); put("ih",1209); put("ig",7316); put("if",239); put("ie",1122); put("hy",251); put("k ",4018); put("ir",2572); put("is",21654); put("it",15297); put("iu",510); put("iv",697); put("iw",1139); put("ii",644); put("ik",10689); put("il",18574); put("im",4535); put("in",32448); put("io",2262); put("ip",8303); put("iz",356); put("iy",6303); put("l ",8749); put("ja",305); put("z ",468); put("wi",4192); put("wo",282); put("ws",238); put("y ",26266); put("wa",7331); put("we",663); put("vi",929); put("vo",293); put("uz",222); put("uy",540); put("uw",938); put("uu",278); put("ve",1065); put("va",717); put("x ",270); put("ui",867); put("uk",2223); put("ul",10829); put("ue",1048); put("ug",2281); put("uh",1222); put("ur",4663); put("us",3997); put("ut",2718); put("um",4571); put("un",11124); put("uo",841); put("up",1559); put("ty",936); put("tu",5349); put("tt",423); put("tw",245); put("ub",2276); put("ua",2314); put("ud",744); put("uc",353); put("w ",2307); put("to",12113); put("tn",494); put("tl",670); put("ts",639); put("tr",2947); put("te",5598); put("ti",12280); put("th",1499); put("ta",23206); put("su",2916); put("ss",697); put("st",7061); put("sy",6204); put("sl",357); put("sk",592); put("sm",643); put("sp",948); put("so",5456); put("sc",415); put("se",6243); put("sh",1082); put("si",9719); put("u ",1011); put("sa",50153); put("rr",466); put("rs",1459); put("rt",2397); put("ru",1218); put("ry",2421); put("rp",226); put("ro",6522); put("rn",1128); put("rm",690); put("rl",534); put("rk",708); put("ri",11065); put("rg",616); put("re",7270); put("rd",981); put("rc",435); put("rb",496); put("ra",14328); put("t ",17794); put("qu",482); put("s ",20143); put("py",238); put("pt",257); put("pu",5533); put("pp",386); put("pr",1443); put("Hul",231); put("za",466); put("zo",453); put("ye",2458); put("ya",16851); put("yb",251); put("yu",966); put("yt",264); put("ys",635); put("yr",507); put("yo",11759); put("yn",980); put("Ara",274); put("Apr",218); put("Asy",352); put("Ayo",1506); put("Bag",274); put("Ban",328); put("Bay",1488); put("Bat",317); put("Abr",300); put("Adi",220); put("Ago",307); put("BN ",257); put("Ale",251); put("Alt",229); put("Ame",579); put("Ang",10467); put("Car",262); put("Bib",239); put("Com",233); put("Col",584); put("Dis",592); put("üd",216); put("Nat",309); put("New",234); put("Nag",476); put("Nor",372); put("Nob",295); put("Pin",243); put("Pil",4628); put("Phi",298); put("Per",237); put("Pas",236); put("Par",288); put("Pag",236); put("Pan",1029); put("Pam",480); put("Pal",436); put("Pro",250); put("Pra",302); put("Que",246); put("Isa",506); put("Ita",502); put("Ito",837); put("Jam",280); put("Jos",222); put("Kab",349); put("Kag",252); put("Kal",869); put("Kan",214); put("Kat",442); put("Kas",598); put("Kar",312); put("Kon",276); put("Leo",280); put("Lat",224); put("Lun",1069); put("Man",377); put("Mal",287); put("Mar",952); put("May",1105); put("Mat",220); put("Min",268); put("Süd",214); put("Zam",212); put("一",621); put("一一",311); put("Sur",412); put("Sta",256); put("Tag",668); put("Siy",420); put("Sil",411); put("Set",224); put("Si ",2472); put("Sam",277); put("Sal",320); put("San",795); put("Sa ",539); put("Rey",251); put("Rep",257); put("Rom",461); put("Uni",749); put("The",357); put("Tim",465); put("Tin",234); put("Tre",501); put("Tsi",277); put("bis",856); put("bit",236); put("bil",2673); put("bin",1170); put("big",1028); put("bo ",562); put("bli",613); put("bla",330); put("bol",310); put("bon",590); put("ban",3506); put("bak",379); put("bal",915); put("bag",1029); put("bah",2518); put("bae",247); put("bab",1067); put("bay",2496); put("baw",340); put("bat",1046); put("bas",870); put("bar",318); put("bi ",266); put("ber",655); put("bel",279); put("bib",346); put("bid",220); put("ca ",245); put("can",254); put("ce ",518); put("bri",332); put("bra",317); put("bre",1519); put("buo",641); put("bul",259); put("bun",360); put("bum",222); put("buh",438); put("but",324); put("bye",332); put("aka",4840); put("am ",867); put("aki",2053); put("akh",385); put("al ",4667); put("ail",347); put("ain",942); put("ais",377); put("ak ",1818); put("aig",364); put("ahi",1712); put("ahu",567); put("aho",893); put("aha",5905); put("agk",1800); put("agl",815); put("agm",409); put("agg",261); put("agh",599); put("agi",2389); put("ags",1175); put("agt",890); put("agu",765); put("ago",873); put("agp",2086); put("anu",622); put("any",1534); put("ano",2033); put("ant",1925); put("ans",2023); put("ane",370); put("ang",54220); put("ani",2704); put("anl",847); put("ap ",1248); put("ana",5631); put("anc",342); put("and",2377); put("amu",411); put("amo",399); put("amp",1054); put("ami",2241); put("ame",660); put("amb",1287); put("ama",6244); put("ao ",2560); put("aly",681); put("alu",885); put("alo",1422); put("alm",256); put("all",403); put("ali",4268); put("ale",940); put("ala",15201); put("alb",295); put("an ",25875); put("aku",295); put("akt",378); put("ako",347); put("akl",349); put("aba",5223); put("abe",285); put("abi",1848); put("abo",410); put("abu",558); put("ae ",378); put("aca",217); put("aaa",370); put("aan",2340); put("aal",228); put("aas",476); put("aar",1310); put("ad ",1547); put("aga",6180); put("agb",737); put("agd",421); put("ado",1685); put("adi",344); put("ade",215); put("ag ",2962); put("ada",1065); put("ayo",1284); put("ayn",676); put("ays",426); put("ayr",437); put("ayu",244); put("ayb",228); put("aya",7316); put("ba ",1007); put("at ",11450); put("are",434); put("ard",406); put("arc",218); put("ara",6094); put("aro",928); put("arl",281); put("ark",258); put("ari",2740); put("ars",347); put("art",1318); put("asa",4127); put("ary",1252); put("asi",1053); put("ase",1923); put("aso",401); put("aon",1107); put("ar ",1507); put("apa",4168); put("api",926); put("apo",968); put("apu",525); put("as ",8041); put("avi",292); put("ay ",22870); put("awa",4711); put("awi",3261); put("ata",9859); put("asu",540); put("ast",1119); put("asy",2814); put("atl",420); put("ato",908); put("ate",772); put("ati",3674); put("ath",277); put("aw ",1870); put("atu",1238); put("aun",478); put("aug",319); put("itn",327); put("ito",5794); put("itu",365); put("ity",376); put("üdt",214); put("ism",492); put("ist",2727); put("isy",1436); put("ita",2453); put("ite",522); put("iti",1834); put("iwa",1084); put("ius",321); put("ive",465); put("ipo",219); put("ipp",279); put("ipi",5953); put("is ",1468); put("ion",1384); put("ipa",894); put("iro",325); put("iri",318); put("isi",1179); put("ish",487); put("ise",486); put("isa",12350); put("ire",294); put("ira",1126); put("it ",3154); put("iyo",1973); put("iya",3692); put("iye",538); put("kik",335); put("kil",1497); put("kin",1435); put("kip",244); put("kit",510); put("ki ",400); put("kha",550); put("koy",367); put("kop",294); put("kon",1105); put("kom",504); put("kol",972); put("ko ",1504); put("kla",2111); put("kay",687); put("kat",4082); put("kau",481); put("kar",1361); put("kas",2326); put("kap",1524); put("kan",3294); put("kal",2502); put("kam",987); put("kak",1114); put("kah",780); put("kai",697); put("kag",306); put("kad",618); put("kab",2686); put("kaa",306); put("ka ",4085); put(" Ga",496); put(" Ge",219); put(" Fr",268); put(" Fi",324); put(" Ha",926); put(" He",600); put(" Go",283); put(" Gr",1130); put(" Gu",254); put(" Gi",361); put(" Hu",696); put(" Ho",300); put("ha ",509); put(" Hi",657); put(" Ja",583); put(" Ir",258); put(" Is",900); put(" It",1471); put(" Im",284); put(" In",3092); put(" Ik",389); put(" Il",402); put("ham",439); put("han",3970); put(" Ka",3625); put("hal",1546); put(" Ki",335); put("har",726); put("has",418); put("hat",613); put(" Jo",502); put(" Ju",282); put("hah",296); put("hag",932); put("hab",327); put(" La",1273); put(" Le",698); put(" Li",486); put(" Ko",738); put(" Kr",232); put("hay",2401); put(" Ku",269); put(" Ma",4113); put(" Mi",784); put(" Me",525); put("he ",726); put(" Lo",362); put(" Lu",1602); put(" Ne",660); put(" Na",1601); put(" Ni",283); put(" Mo",516); put(" Mu",380); put("her",391); put("hen",301); put("hi ",256); put(" Ap",381); put(" Am",732); put(" An",10945); put(" Ak",280); put(" Al",957); put(" Ag",601); put(" Ad",338); put(" Ab",444); put(" Ba",3213); put(" Ay",1524); put(" Au",300); put(" As",625); put(" Ar",684); put("hig",262); put(" Be",553); put(" Bi",731); put("hip",233); put("hin",2102); put("him",317); put(" Bo",624); put("hil",1124); put(" Br",411); put(" Bu",508); put("hit",252); put("hiy",1822); put(" Ca",1275); put(" Ce",318); put(" Ch",477); put(" Co",1435); put(" Da",1001); put(" Di",1559); put(" De",354); put(" Do",218); put(" Es",753); put(" En",683); put(" Em",287); put(" Eu",251); put(" Fe",229); put("gma",404); put("go ",1131); put(" Sü",216); put("gle",2258); put("gli",561); put("gla",763); put(" Wi",299); put("gko",362); put(" Wa",224); put(" Za",253); put("gna",429); put("gmu",288); put("gpu",1231); put("gpa",814); put("gon",726); put("gos",419); put("gor",456); put("gsa",661); put("gsi",395); put("gra",396); put("gre",308); put(" Or",329); put(" Po",510); put("gui",242); put(" Pi",5194); put("gum",355); put(" Ph",516); put("gul",619); put(" Pe",751); put(" Pa",3220); put("gsu",217); put("gso",1676); put(" No",856); put(" Ol",245); put(" Ok",212); put("gta",876); put(" Ra",342); put(" Qu",347); put(" Ro",902); put(" Re",1013); put(" Ri",307); put(" Pr",781); put("gus",319); put(" Pu",319); put("gun",828); put(" Su",840); put(" St",567); put(" Ta",1427); put("gya",341); put(" Th",565); put(" Ti",1025); put(" Te",369); put(" Tr",725); put(" Ts",304); put(" To",289); put(" Sa",2358); put(" Sh",292); put(" Si",3946); put(" Sc",224); put(" Se",748); put(" So",478); put(" Va",226); put(" Vi",396); put(" Tu",256); put(" Un",1043); put("ial",214); put("ian",1841); put(" ip",821); put(" im",295); put(" in",1205); put(" ik",2724); put(" il",559); put("ic ",391); put(" is",12317); put(" it",4118); put("ibl",298); put("ibi",852); put(" ka",12843); put("ibo",539); put(" ki",1772); put("id ",624); put("iba",1373); put("ibe",241); put(" ha",2342); put(" he",266); put(" gi",1221); put(" gr",273); put("ia ",1668); put(" gu",642); put(" ib",1270); put(" hi",1628); put(" hu",502); put(" ni",3203); put(" ng",29501); put(" ne",259); put("ien",313); put(" na",26725); put(" mu",2405); put("ig ",1084); put(" mo",343); put(" of",748); put(" no",3658); put(" le",482); put("ict",361); put(" li",1169); put(" la",4719); put(" ku",1926); put("ich",298); put(" kl",1518); put("ica",454); put(" ko",1618); put(" me",432); put(" mg",9378); put(" mi",835); put(" o ",6532); put("ido",754); put(" ma",12562); put(" lu",1621); put("ide",429); put("ida",693); put(" lo",567); put(" ag",287); put(" aa",479); put(" an",11487); put(" ap",351); put(" ak",588); put(" al",688); put(" aw",224); put(" ar",1782); put(" at",8491); put("iit",294); put(" as",396); put(" ba",6398); put(" ay",15608); put("il ",1019); put(" bi",3286); put(" be",279); put(" bo",263); put(" bl",303); put(" bu",1574); put(" ca",215); put("im ",631); put("ika",5845); put("igd",340); put("ige",351); put("iga",3450); put("igm",226); put("igi",608); put("iha",656); put("ihi",488); put("ik ",530); put("imo",757); put(" es",477); put(" em",253); put("imp",821); put(" el",218); put("ime",284); put(" ek",212); put("imi",396); put("ip ",377); put("ind",1253); put("ina",12544); put("imu",413); put("ino",1637); put("int",735); put("ins",494); put("ine",925); put("ing",7215); put("ini",1991); put(" ga",1201); put("inu",1256); put("iko",1955); put(" co",595); put("iki",665); put("ila",8566); put("in ",3710); put(" da",2205); put("iku",803); put("iks",322); put("ilo",675); put("ill",466); put(" de",1318); put("ili",6551); put(" di",1938); put("ima",551); put("imb",583); put("io ",525); put("ily",587); put(" du",359); put("hol",219); put("hon",897); put(" ye",394); put("hul",550); put(" sa",28976); put(" se",2207); put(" si",4160); put(" so",365); put(" t ",331); put(" re",1237); put(" ri",835); put(" pu",1239); put(" pr",891); put(" s ",272); put("hum",213); put(" op",300); put(" or",499); put(" pe",850); put(" pa",17344); put(" pl",235); put(" po",2264); put(" pi",2508); put(" wa",403); put(" wi",495); put(" tu",1581); put(" ur",1186); put(" up",417); put(" um",236); put(" un",787); put(" ta",3807); put(" su",1227); put(" tr",542); put(" th",440); put(" ti",1513); put(" te",623); put("eyn",227); put("eta",377); put("eti",227); put("esp",220); put("eso",216); put("est",873); put("ess",243); put("esy",238); put("eto",217); put("etr",240); put("ety",252); put("ey ",259); put("er ",1701); put("es ",4679); put("epu",270); put("eri",1261); put("ere",336); put("era",1743); put("erb",250); put("et ",365); put("esi",397); put("ery",584); put("ert",284); put("ers",877); put("ern",685); put("erm",213); put("ero",994); put("eks",315); put("ekt",395); put("en ",605); put("ela",487); put("ele",614); put("eli",929); put("ell",447); put("eo ",676); put("emb",1031); put("ema",617); put("eme",244); put("emo",250); put("emi",251); put("emp",247); put("ene",540); put("eng",2031); put("ena",338); put("end",702); put("enc",265); put("ens",1983); put("ent",2381); put("ego",798); put("ege",495); put("ehi",1394); put("el ",1262); put("eka",275); put("gka",2797); put("git",1186); put("gis",283); put("gil",253); put("gin",2170); put("gha",696); put("ggi",233); put("gga",1607); put("gi ",930); put("gen",305); put("gda",265); put("gdi",448); put("ge ",872); put("gbi",301); put("gba",311); put("gag",358); put("gah",212); put("gas",721); put("gar",389); put("gat",1029); put("gaw",951); put("gay",1184); put("gam",1160); put("gal",2016); put("gan",8911); put("gap",698); put("ga ",10893); put("da ",1215); put("de ",630); put("dad",487); put("daa",229); put("dal",1278); put("dai",337); put("dag",294); put("dah",789); put("dat",526); put("dar",615); put("dan",716); put("dam",364); put("cti",321); put("co ",247); put("com",405); put("ch ",248); put("cha",297); put("cia",252); put("ck ",232); put("che",214); put("ed ",364); put("ebr",372); put("ean",218); put("ear",435); put("eap",318); put("ea ",269); put("ega",369); put("edi",305); put("dya",287); put("dor",701); put("don",511); put("dos",801); put("dti",217); put("dul",227); put("duk",249); put("dia",320); put("der",377); put("des",307); put("del",555); put("dek",245); put("den",404); put("di ",862); put("do ",1342); put("diy",230); put("din",1025); put("dis",689); put("dit",243); put("dig",691); put("rga",250); put("ri ",1883); put("res",909); put("rea",358); put("reg",609); put("reh",760); put("ren",823); put("rel",229); put("rer",338); put("re ",1785); put("raw",1292); put("rd ",279); put("rap",411); put("ras",562); put("rat",708); put("rag",342); put("ran",3019); put("ram",928); put("ral",1710); put("rab",295); put("raa",290); put("rad",734); put("rs ",234); put("ros",487); put("rot",255); put("ron",875); put("roo",656); put("rop",486); put("rod",249); put("rol",389); put("rna",412); put("rne",221); put("ro ",2000); put("rma",307); put("riy",449); put("rit",895); put("ris",641); put("rig",228); put("ril",614); put("rik",932); put("rin",2120); put("ria",1493); put("ric",296); put("rie",322); put("rk ",265); put("rya",408); put("rup",247); put("rus",239); put("ry ",568); put("rsi",370); put("rso",362); put("rte",436); put("rti",1012); put("saa",543); put("sab",432); put("sag",340); put("sah",246); put("sak",534); put("sal",1402); put("sam",846); put("sap",373); put("san",13859); put("sas",644); put("sar",588); put("say",842); put("sa ",29066); put("ryo",1185); put("shi",267); put("si ",909); put("siy",1352); put("sid",252); put("sia",279); put("sit",454); put("sis",871); put("sip",588); put("sin",2020); put("sil",886); put("sim",530); put("sik",667); put("sig",229); put("se ",703); put("ser",748); put("ses",480); put("sh ",511); put("sen",3264); put("spe",263); put("spa",238); put("son",453); put("sod",1704); put("st ",395); put("ss ",216); put("sla",213); put("smo",455); put("so ",2182); put("sye",492); put("sya",1319); put("syo",3972); put("syu",310); put("ste",723); put("sta",2233); put("sto",847); put("sti",1338); put("str",1197); put("sub",226); put("sul",377); put("sum",409); put("suk",222); put("sun",606); put("sus",423); put("tak",378); put("tal",1825); put("tag",2356); put("taa",516); put("tab",313); put("tad",729); put("tay",910); put("taw",1462); put("tat",2169); put("tas",1294); put("tar",426); put("tap",454); put("tao",2928); put("tan",3973); put("tam",283); put("te ",1421); put("ta ",2620); put("pa ",793); put("par",2056); put("pat",1511); put("pas",473); put("pay",244); put("paa",836); put("pab",282); put("pag",5944); put("pah",588); put("pak",582); put("pal",1553); put("pap",964); put("pam",2183); put("pan",7375); put("pi ",308); put("per",1160); put("pel",619); put("pla",312); put("pik",487); put("pil",381); put("pin",8127); put("pis",517); put("pit",481); put("por",477); put("pop",1613); put("pos",639); put("pon",910); put("pol",471); put("ppi",245); put("po ",494); put("pua",1158); put("pub",334); put("pri",362); put("pre",283); put("pro",666); put("put",222); put("pun",775); put("pul",2278); put("ra ",2777); put("ngo",322); put("ngi",702); put("ngl",2579); put("ngk",1509); put("ngu",1141); put("ngr",246); put("ngs",1763); put("ni ",1903); put("nge",218); put("ngg",1999); put("ngh",357); put("nga",5141); put("nel",268); put("ner",635); put("net",328); put("nes",773); put("ng ",107416); put("nce",344); put("ne ",832); put("ndu",336); put("ndo",855); put("ndi",1104); put("nde",357); put("nda",2122); put("nak",3214); put("nal",1987); put("nam",1069); put("nan",5284); put("nao",281); put("nap",1249); put("nar",667); put("nad",394); put("nag",3410); put("nah",1201); put("nai",343); put("nab",490); put("nd ",696); put("nau",287); put("nat",2025); put("nas",5521); put("nay",628); put("naw",416); put("na ",22155); put("nya",1473); put("nul",380); put("num",251); put("nun",621); put("nus",223); put("nut",274); put("nub",254); put("nto",1170); put("ntu",218); put("ntr",369); put("nti",1113); put("nta",1619); put("nte",1041); put("nsy",292); put("nso",1561); put("nst",288); put("nse",338); put("nsi",398); put("nsa",1639); put("nt ",493); put("ns ",315); put("nod",444); put("noo",3554); put("nom",260); put("non",1292); put("nla",384); put("no ",3206); put("nlu",471); put("nid",488); put("nib",262); put("nia",263); put("niy",508); put("niw",515); put("niv",230); put("nis",952); put("nit",1670); put("nim",327); put("nin",947); put("nik",402); put("nil",1831); put("ogr",242); put("ohi",487); put("ok ",961); put("ol ",1113); put("oby",351); put("ode",251); put("of ",743); put("og ",1738); put("ob ",490); put("od ",2512); put("obe",281); put("nyo",656); put("oto",243); put("ost",571); put("ota",234); put("osi",296); put("ose",518); put("oso",256); put("oy ",861); put("oun",298); put("opo",245); put("opi",377); put("ope",331); put("os ",2497); put("opu",1605); put("oon",4273); put("ook",406); put("oob",454); put("or ",1386); put("ork",236); put("orm",244); put("oro",293); put("ord",364); put("ore",565); put("org",297); put("ori",875); put("osa",225); put("ort",603); put("ory",303); put("ot ",787); put("ora",483); put("ola",327); put("on ",10511); put("oli",798); put("oll",560); put("ole",828); put("olo",1158); put("ona",1108); put("ond",258); put("one",582); put("ong",14203); put("oni",381); put("ono",505); put("ons",429); put("ont",363); put("ony",253); put("oma",662); put("ome",348); put("omi",484); put("omm",343); put("omp",399); put("omo",218); put("op ",492); put("la ",7051); put("le ",657); put("laa",472); put("lab",1035); put("lad",618); put("lah",600); put("lag",1451); put("lal",5124); put("lak",2054); put("lan",8966); put("lam",1407); put("lap",417); put("lar",1484); put("lat",1650); put("las",3731); put("law",4043); put("lay",1014); put("lba",235); put("ld ",260); put("kuy",222); put("kun",1182); put("kum",367); put("kul",1301); put("ksy",373); put("ksi",218); put("ktu",302); put("kto",418); put("lon",1346); put("loo",506); put("lor",222); put("loh",474); put("log",979); put("los",411); put("lto",257); put("lug",603); put("li ",620); put("les",2603); put("lem",360); put("len",771); put("leh",645); put("leg",553); put("lea",415); put("lo ",1738); put("lla",492); put("lle",760); put("ll ",320); put("lit",1575); put("lis",938); put("lip",5499); put("lin",1820); put("lim",971); put("liy",225); put("lic",224); put("lid",294); put("lia",495); put("lib",291); put("lik",1738); put("lil",346); put("lii",293); put("lig",604); put("lih",227); put("ma ",1406); put("maa",656); put("mab",485); put("mah",1161); put("mai",353); put("mak",856); put("mad",287); put("mag",1774); put("map",283); put("mar",866); put("mas",904); put("mal",1856); put("mam",1144); put("man",4514); put("may",4380); put("mat",2454); put("mba",1424); put("mbr",990); put("mbo",357); put("me ",332); put("med",215); put("met",267); put("mes",455); put("mer",827); put("men",704); put("luk",293); put("lup",252); put("lun",1075); put("lum",601); put("lut",234); put("lus",323); put("lur",429); put("lya",1073); put("lyo",437); put("mpi",405); put("mpe",729); put("mpo",376); put("mpu",307); put("mog",636); put("mon",703); put("mot",220); put("mpa",1165); put("mus",340); put("mut",297); put("mul",2510); put("mun",975); put("mga",9380); put("min",1128); put("mil",657); put("mis",408); put("mit",1305); put("mik",544); put("mo ",604); put("mmu",273); put("zon",372); put("yun",445); put("ysa",370); put("yro",432); put("yos",430); put("yon",8581); put("yea",322); put("yeg",287); put("yen",248); put("yem",924); put("ya ",5481); put("yag",346); put("yar",349); put("yan",8889); put("yal",500); put("yo ",2106); put("yna",235); put("yni",658); put("wit",490); put("wig",2597); put("wik",476); put("wa ",1340); put("wan",2646); put("wal",851); put("wak",321); put("wat",242); put("war",240); put("wag",936); put("ver",481); put("ve ",253); put("va ",222); put("uya",331); put("uwe",288); put("uwa",445); put("usi",309); put("usa",537); put("usy",243); put("usu",363); put("ust",456); put("uti",335); put("ute",297); put("uta",417); put("utu",829); put("uto",373); put("us ",1413); put("ura",1051); put("ure",277); put("uri",1726); put("uro",457); put("uny",224); put("uon",264); put("upa",766); put("ur ",441); put("upo",374); put("ump",364); put("umu",925); put("umi",469); put("uma",1769); put("umb",268); put("uly",233); put("uo ",439); put("unt",520); put("unu",378); put("uni",882); put("uno",1281); put("und",796); put("una",2530); put("ung",3950); put("uku",387); put("uko",610); put("um ",503); put("uka",453); put("ulu",1033); put("ult",291); put("ulo",1229); put("uli",710); put("ula",6857); put("uin",299); put("ugn",288); put("uga",1124); put("uha",936); put("ubo",309); put("ubr",217); put("ubu",535); put("ue ",245); put("uez",255); put("uan",1897); put("ubi",307); put("ubl",385); put("uba",263); put("tye",228); put("ty ",596); put("tur",814); put("tut",349); put("tul",834); put("tuk",407); put("tun",595); put("tum",594); put("tub",614); put("tra",868); put("tri",838); put("tro",879); put("to ",7587); put("tna",387); put("tom",241); put("ton",2028); put("tol",467); put("tor",922); put("til",777); put("tik",1397); put("tig",242); put("tir",721); put("tit",772); put("tis",888); put("tin",3062); put("tim",775); put("tip",230); put("tio",1023); put("tib",304); put("tid",407); put("tiy",331); put("tlo",414); put("tem",511); put("ten",352); put("tel",392); put("th ",280); put("tes",226); put("ter",1925); put("ti ",555); put("the",612); put("tha",237); }};
    private static final int[] n_words_s = {2110634,2489828,1864789};
    private static final String name_s = "tl";

    public Profile_tl() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
