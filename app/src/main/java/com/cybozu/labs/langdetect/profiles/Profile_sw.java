package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_sw extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>(1770) {{ put("jer",348); put("jen",305); put("ji ",6234); put("D",1805); put("E",874); put("F",1081); put("G",1202); put("A",4461); put("B",2717); put("C",2251); put("L",1530); put("M",12761); put("N",2782); put("O",860); put("H",1677); put("I",2605); put("J",2641); put("K",12188); put("U",3120); put("T",5185); put("W",4730); put("V",1116); put("P",2090); put("S",3343); put("R",1632); put("Y",517); put("Z",395); put("f",11048); put("g",13829); put("d",15034); put("e",46694); put("Feb",214); put("b",19688); put("c",9784); put("a",289584); put("n",90468); put("o",57043); put("l",42025); put("m",53651); put("j",21456); put("k",76835); put("h",32492); put("i",164978); put("w",60984); put("v",3863); put("u",57506); put("t",40551); put("s",35298); put("r",27443); put("p",13501); put("z",18893); put("y",38832); put("x",501); put("jar",185); put("jan",137); put("jaw",201); put("é",167); put("jim",1500); put("jin",4267); put("jil",163); put("jij",492); put("jia",221); put("jib",3854); put("ito",288); put("itu",317); put("itw",269); put("isp",140); put("ist",592); put("ita",1061); put("ite",213); put("iti",334); put("ivy",133); put("iwa",2430); put("ius",183); put("ipo",224); put("ipi",265); put("is ",521); put("ion",720); put("iop",279); put("ipa",165); put("ipe",219); put("iro",173); put("iri",997); put("isi",902); put("ish",5756); put("isa",694); put("ire",164); put("ira",314); put("ja ",1529); put("iyo",4644); put("iye",227); put("izo",242); put("izi",413); put("iza",568); put(" l",8602); put("kif",518); put(" m",27935); put(" n",19872); put(" o",327); put("kik",333); put(" h",7652); put(" i",9059); put("kij",166); put("kim",258); put(" j",5212); put("kil",389); put(" k",27977); put(" d",1010); put(" e",802); put(" f",914); put("kia",390); put(" g",257); put(" a",6533); put(" b",1252); put(" c",2191); put("kiw",279); put(" y",17767); put(" z",2257); put("kin",442); put(" u",4361); put("kio",148); put(" t",2402); put("kip",379); put(" w",34366); put(" v",1482); put("kis",520); put(" p",2154); put("kit",315); put(" s",6097); put(" r",837); put("ki ",2193); put(" J",2627); put(" K",12017); put(" H",1638); put(" I",2128); put(" N",2678); put(" O",803); put(" L",1487); put(" M",12665); put(" B",2646); put(" C",2112); put(" A",4277); put(" F",1046); put(" G",1172); put(" D",1740); put(" E",782); put(" Z",375); put(" Y",513); put("и",142); put(" S",3229); put(" R",1588); put("а",137); put(" P",2015); put(" W",4707); put(" V",1031); put(" U",3052); put(" T",5117); put("kea",156); put("kem",150); put("ke ",1988); put("ku ",187); put("kri",520); put("kon",141); put("koa",3734); put("ko ",1214); put("ل",165); put("ا",240); put("juu",155); put("jul",257); put("jum",177); put("kaz",5045); put("kaw",137); put("kat",14149); put("kar",374); put("kas",316); put("kan",2795); put("kao",197); put("kal",354); put("kam",1048); put("kad",160); put("kab",375); put("ka ",19783); put(" Ga",196); put("Da",365); put(" Ge",229); put("Co",364); put(" Fr",177); put("Ch",770); put(" Ha",622); put(" He",218); put(" Go",142); put("Do",469); put(" Gr",177); put(" Gu",142); put("De",497); put("Di",169); put("Fe",311); put(" Id",148); put("Fa",160); put(" Hu",173); put(" Ho",177); put(" II",154); put("ha ",2668); put(" Hi",392); put("Ge",229); put(" Ji",535); put("Ga",198); put(" Je",286); put("I ",397); put(" Ja",792); put("Fr",177); put(" Ir",284); put(" Is",141); put(" It",181); put(" In",316); put(" Ik",143); put(" Il",224); put("ham",522); put("han",444); put("hap",154); put(" Ka",2225); put("hai",238); put("haj",163); put("hak",611); put("hal",314); put(" Ke",708); put(" Ki",3568); put("har",1714); put("has",255); put("hat",148); put(" Jo",255); put("II ",207); put(" Ju",691); put("hag",267); put("hab",181); put("had",740); put(" La",231); put(" Le",207); put(" Li",441); put(" Ko",414); put(" Ku",695); put(" Kw",4009); put("Au",181); put(" Ma",4258); put(" Mb",461); put("Ar",475); put("As",222); put(" Mk",3388); put("Ba",771); put(" Mi",685); put(" Mj",478); put(" Me",615); put("Af",445); put("he ",544); put("Ag",372); put(" Lo",213); put("Am",241); put("An",463); put("Ap",290); put(" Lu",315); put("Al",840); put(" Ne",518); put("Bu",429); put("Br",278); put(" Na",464); put("Ca",592); put(" Ni",435); put("Bi",308); put(" Mt",420); put("Be",362); put(" Mp",146); put(" Mo",643); put("Bo",282); put(" Mu",471); put(" Mw",545); put("Ku",695); put("Kw",4009); put("Ko",415); put("hez",299); put("Le",210); put("Li",441); put("hes",336); put("her",275); put("hen",226); put("hem",395); put("La",231); put("Lu",315); put("Lo",213); put("Me",621); put("hi ",3880); put("Mi",690); put("Mj",478); put("Mk",3388); put("Ma",4263); put("Mb",461); put("Mw",546); put("Mu",475); put("Mt",420); put("Mp",146); put("Mo",643); put("Ni",437); put("Ne",518); put("Na",466); put(" Ap",290); put(" Am",240); put(" An",463); put(" Al",833); put("Ny",247); put(" Ag",372); put(" Af",443); put("No",466); put(" Ba",766); put("Ok",277); put(" Au",181); put(" As",222); put(" Ar",474); put(" Be",362); put(" Bi",308); put("hio",2603); put("Gr",177); put("Go",143); put("hin",1991); put("him",244); put("hil",432); put("Gu",142); put(" Bo",282); put("hii",230); put(" Br",278); put(" Bu",429); put("his",266); put("hir",394); put("Ha",622); put(" Ca",582); put("hiy",239); put("He",219); put("II",286); put("Hi",393); put(" Ch",768); put("Ho",179); put("Hu",173); put(" Co",362); put("K ",152); put("Id",148); put(" Da",365); put(" Di",167); put("In",317); put(" De",495); put("Ik",143); put("Il",226); put("Is",141); put("It",181); put(" Do",469); put("Ir",284); put("Ja",792); put("Ji",536); put("Je",286); put("Jo",255); put("Ju",691); put("Ka",2234); put("Has",225); put("ho ",334); put(" Fe",311); put("Ki",3577); put(" Fa",159); put("Ke",708); put("Us",172); put("Ut",325); put("Ur",181); put("go ",920); put("Un",355); put("Uk",150); put("Ul",189); put("Ui",244); put("Uj",249); put("Uh",170); put("Uf",251); put("Uc",175); put("Tu",237); put("To",205); put("Th",275); put("Te",258); put(" Wi",3377); put("Ta",3841); put(" We",188); put(" Wa",1003); put("St",260); put("Su",178); put("Wi",3380); put("Wa",1003); put("We",189); put(" Zi",141); put(" Za",152); put("Vi",670); put(" Yo",250); put("Pr",150); put("Pe",270); put("goz",233); put("Pa",858); put("Po",195); put("Pi",163); put("gom",190); put("gon",205); put("gos",279); put("gor",306); put("Se",532); put("gu ",424); put("Si",424); put("Sh",518); put("So",239); put("Ru",370); put("Sa",668); put("Re",188); put("Ri",138); put("Ro",385); put("Ra",354); put(" Po",195); put("guj",253); put(" Pi",163); put(" Pe",270); put(" Pa",857); put(" Ny",247); put(" No",466); put(" Ok",277); put(" Ra",354); put("b ",211); put(" Ro",385); put("gwe",166); put(" Re",188); put(" Ri",138); put("gwa",280); put("guz",429); put(" Pr",150); put("a ",143240); put(" Su",178); put(" St",248); put(" Ta",3838); put(" Th",274); put("Yo",250); put(" Te",257); put(" To",205); put(" Ru",370); put(" Sa",668); put(" Sh",517); put(" Si",421); put(" Se",528); put(" So",239); put(" Vi",666); put(" Tu",231); put("Za",152); put("Zi",141); put(" Uc",175); put(" Uf",251); put(" Uh",170); put(" Ui",243); put(" Uj",249); put(" Uk",150); put(" Ul",189); put(" Un",355); put(" Ur",181); put(" Us",172); put(" Ut",325); put(" ja",134); put("iak",142); put("i ",52347); put("ian",874); put(" ji",4522); put("ias",364); put("ge",1928); put("iar",235); put(" je",226); put("ga",2900); put(" im",145); put(" in",3363); put(" ik",274); put(" il",4878); put("fi",1075); put("fr",504); put("fu",1927); put("fo",752); put("ibl",142); put("ibi",603); put(" ka",16147); put("gw",483); put(" ki",3027); put("he",2541); put("ibu",4111); put("ha",8898); put("gl",145); put("gi",1836); put("gh",1233); put("gu",1858); put("iba",566); put(" ju",300); put("go",2336); put("du",838); put("dw",136); put("g ",607); put(" ha",1606); put("ea",1091); put("eb",539); put(" he",144); put("ec",251); put("ed",686); put("de",1841); put("di",4816); put("dh",617); put("do",1639); put("ia ",9119); put("dr",203); put("ew",912); put("ex",163); put("eu",261); put("ev",332); put("ey",739); put("ez",1828); put("fa",6104); put("h ",704); put(" id",219); put("fe",174); put("eh",737); put(" hi",990); put("eg",644); put("ef",303); put("ee",307); put("el",2120); put("ek",2577); put("ej",155); put(" ho",139); put("ei",650); put("ep",643); put("eo",1165); put("en",9965); put("em",2423); put("et",1296); put(" hu",4749); put("es",2258); put("er",4147); put(" nj",147); put("ca",364); put(" ni",9330); put("e ",10467); put(" ng",147); put(" nd",690); put("bw",843); put(" nc",2455); put(" na",6269); put("br",408); put("bu",5373); put("bo",2905); put(" mw",6857); put("bl",321); put(" mu",4335); put(" mt",648); put(" ms",331); put("bi",2134); put(" mp",280); put(" mo",680); put(" mn",1501); put("be",1280); put(" mm",157); put("ifu",393); put("da",3239); put("f ",246); put("ifo",606); put(" of",164); put("co",390); put(" ny",523); put("ck",301); put("ci",283); put("ch",7388); put("ce",365); put("ifa",585); put(" le",184); put("c ",192); put(" li",859); put(" la",7153); put(" ku",5668); put("ich",830); put(" kw",2736); put(" km",140); put("ica",140); put(" ko",150); put(" me",184); put(" mf",368); put("az",6015); put("ay",5308); put(" mi",1257); put("ba",6016); put(" mj",5191); put(" mk",1617); put("d ",1205); put("at",22079); put("as",4908); put("ar",9773); put(" ma",3449); put(" mb",469); put("aw",1490); put(" mc",155); put("av",414); put("au",1667); put(" lu",341); put("ak",14678); put("al",8458); put("idi",551); put("ai",5267); put("aj",1998); put("ao",6210); put("ap",5739); put("ide",157); put("am",9111); put("an",29556); put("ac",1224); put("ad",3126); put("ida",813); put("aa",1773); put("ab",2568); put("ag",1596); put("ah",1414); put("ae",682); put("af",1092); put("nu",591); put("nt",1270); put("ns",4895); put("no",1318); put("nn",478); put(" am",1335); put(" an",488); put("nz",5093); put(" ai",153); put("iin",242); put("ny",7307); put(" aj",134); put(" ak",183); put(" al",2589); put("of",4380); put(" au",941); put("oc",308); put("od",678); put("oa",4118); put("ob",631); put(" at",195); put(" as",220); put("om",1846); put("on",3853); put("ok",2328); put(" ba",679); put("ol",1930); put("oi",1488); put("oj",1425); put("og",855); put("oh",360); put("ija",140); put("ot",1280); put(" bi",222); put("os",1066); put("ov",580); put("ou",534); put("ije",137); put("op",845); put("oo",318); put("or",2938); put("iji",1232); put("r ",1622); put("ow",244); put("oz",397); put("oy",154); put("pe",836); put("pa",6921); put("po",1264); put("ph",151); put("pi",2193); put("ika",13864); put("lo",1408); put("lm",337); put("Ida",135); put("ll",791); put("ls",182); put("iga",224); put("ii ",525); put("lu",868); put("lt",178); put("igh",170); put("igi",384); put("ly",147); put("o ",24303); put("mc",173); put("igo",169); put("ma",8274); put("mb",6660); put("mh",261); put("me",2630); put("mf",564); put("mk",1733); put("ml",210); put("mi",3477); put("mj",5199); put("mn",1546); put("mm",321); put("mp",578); put("ihe",138); put("mo",6079); put("mr",140); put("mt",753); put("ms",447); put("mu",6394); put("mw",6988); put("ihi",187); put("p ",352); put("na",23279); put("nc",2788); put("nd",5575); put("ne",2353); put("ng",6858); put("ni",24361); put("nj",567); put("nk",135); put("imo",196); put(" es",141); put(" en",369); put("ju",713); put("imf",161); put("ime",354); put(" el",223); put("jo",133); put("imi",180); put("ki",6922); put("kh",154); put("ind",834); put("ke",2748); put("ina",8001); put(" fa",353); put("ka",45110); put("imu",392); put("m ",727); put(" fu",177); put("kw",3124); put("ino",181); put("ks",210); put("kt",463); put("ku",10532); put("ins",133); put("ko",5804); put("ine",479); put("ing",1959); put("kr",669); put(" fi",274); put("ini",4598); put("km",156); put("li",17984); put("le",2997); put("ld",221); put("lf",159); put("la",14880); put("lb",250); put("iny",275); put("n ",3144); put("iko",612); put("hw",492); put("ht",198); put("hu",6825); put("iki",2488); put("hi",11111); put(" ch",2090); put("hn",150); put("ho",1180); put("ila",4379); put("id",1813); put("ic",1403); put("ib",5595); put("ia",11251); put("ih",490); put("in ",378); put("ig",1252); put(" da",146); put("if",1790); put("ie",672); put("iku",2496); put("k ",628); put("ilo",373); put("ir",1982); put("is",9376); put("it",2904); put("ill",288); put("iu",466); put("iv",385); put("iw",2556); put("ii",989); put("ij",1580); put("ik",19966); put(" de",224); put("ili",8251); put("il",13887); put("im",4832); put("in",17333); put("io",4395); put("ile",321); put("ip",1169); put("ima",914); put("je",934); put("imb",2471); put("io ",2960); put("ji",17145); put("iz",1362); put("iy",4997); put(" du",302); put("l ",1018); put("ja",2368); put("z ",191); put("wi",1773); put("wo",202); put("vy",671); put(" za",1702); put("y ",1239); put("wa",56175); put(" zi",456); put("we",2203); put("vi",1632); put("vu",418); put("vo",138); put("uz",1451); put("uw",2877); put("uv",252); put("uu",3068); put(" ye",258); put("ve",578); put(" ya",17428); put("va",328); put("x ",213); put("ui",563); put("uj",4429); put("uk",1643); put("ul",2575); put("ue",357); put("uf",741); put("ug",901); put("uh",626); put("ur",1919); put("us",3274); put("ut",2784); put("um",5397); put("un",5099); put("uo",368); put("up",1077); put("ty",166); put("tu",2287); put("tt",391); put("tw",473); put("ub",1112); put("ua",2111); put("ud",534); put("uc",476); put("w ",435); put("to",4407); put("huk",345); put("hul",146); put("tl",220); put("ts",343); put("tr",455); put("te",2280); put("ti",12092); put("th",999); put("ta",14867); put("su",644); put("ss",500); put("st",1842); put("sw",308); put("sl",142); put("sk",865); put("sm",139); put("sp",289); put("so",683); put("sc",179); put("se",5649); put("sh",8151); put("si",4764); put("u ",13704); put("sa",7736); put("rr",220); put("rs",467); put("rt",620); put("ru",2279); put("ry",287); put("ro",1786); put("rn",619); put("rm",257); put("rl",223); put("rk",320); put("ri",8157); put("rg",403); put("re",3855); put("rd",556); put("rc",143); put("rb",136); put("ra",5018); put("t ",1231); put("s ",3025); put("pt",348); put("pu",357); put("pw",193); put("pr",381); put(" sa",589); put(" se",4480); put(" si",369); put(" sh",318); put(" ra",432); put(" ri",188); put("hwa",473); put("huo",175); put("hum",2789); put("hun",282); put("hus",506); put("hur",418); put("huu",1333); put(" pe",176); put(" pa",632); put(" pi",931); put(" wa",33135); put(" we",275); put(" vy",396); put(" wi",862); put(" vi",1013); put(" uc",144); put("zi",8597); put("ze",368); put("za",8043); put(" tu",189); put("zw",257); put(" us",165); put(" ut",249); put(" up",502); put(" um",247); put("zu",272); put(" un",1571); put(" uk",210); put("zo",952); put(" ul",573); put(" uh",139); put(" ta",1410); put("ye",2395); put("ya",24129); put("yu",306); put(" to",170); put(" th",289); put("yo",5888); put(" te",201); put("yi",4283); put("Apr",266); put("Asi",146); put("Aru",195); put("far",316); put("fam",283); put("fan",4203); put("fal",292); put("fa ",488); put("eya",259); put("Bah",237); put("Bar",140); put("eza",1136); put("ezo",172); put("ezi",237); put("eta",229); put("ete",154); put("eti",253); put("est",247); put("ett",212); put("ew ",355); put("evi",165); put("ewe",148); put("ey ",361); put("ewa",358); put("er ",615); put("epa",149); put("es ",640); put("ept",299); put("eri",650); put("ere",660); put("era",456); put("Afr",406); put("esh",359); put("ese",306); put("esa",279); put("eru",498); put("Ago",254); put("ert",152); put("ers",339); put("eku",184); put("en ",297); put("ela",204); put("ele",786); put("eli",360); put("ell",177); put("eo ",852); put("emb",1055); put("ema",157); put("eme",314); put("emi",276); put("emu",365); put("ene",704); put("eng",671); put("ena",283); put("end",498); put("eno",221); put("eni",486); put("ens",4087); put("ent",441); put("eny",1803); put("Ali",478); put("ege",351); put("Ame",158); put("ehe",647); put("Ana",176); put("el ",260); put("eke",267); put("eka",1754); put("giz",193); put("gir",232); put("gin",349); put("gid",165); put("ght",136); put("gha",925); put("gi ",572); put("gen",204); put("ger",781); put("ge ",611); put("gaz",140); put("gar",155); put("gan",693); put("ga ",1334); put("Cal",307); put("fup",194); put("Bib",137); put("fua",317); put("fum",143); put("fun",167); put("fri",445); put("fu ",810); put("for",356); put("fo ",342); put("fil",269); put("fik",168); put("fiz",146); put("da ",1525); put("de ",752); put("dad",386); put("dae",220); put("dar",151); put("dan",305); put("dam",173); put("Des",272); put("Dar",167); put("Chi",216); put("Chu",136); put("Cha",300); put("ch ",165); put("cha",2430); put("chu",596); put("ck ",143); put("che",571); put("chi",3152); put("cho",370); put("ed ",154); put("ebr",313); put("ea ",663); put("ei ",346); put("efu",197); put("edi",297); put("ee ",156); put("don",150); put("dom",308); put("dol",151); put("dog",335); put("dun",335); put("dha",302); put("dia",330); put("dhi",240); put("der",146); put("deg",261); put("del",152); put("di ",2661); put("do ",429); put("Dod",240); put("diy",201); put("din",291); put("dis",387); put("dik",302); put("ri ",2373); put("rez",420); put("rea",148); put("ref",154); put("reh",266); put("ren",163); put("rek",1672); put("re ",305); put("rd ",213); put("ras",256); put("rat",173); put("Ni ",218); put("New",381); put("rai",160); put("ran",867); put("ram",226); put("rab",297); put("rad",150); put("ron",135); put("rog",253); put("rne",169); put("rni",283); put("ro ",593); put("riw",166); put("ris",508); put("ril",300); put("rik",1688); put("rin",373); put("ria",769); put("rib",1011); put("ric",160); put("rk ",191); put("ruf",262); put("rum",452); put("ruk",315); put("rus",423); put("ry ",194); put("rse",228); put("Nya",144); put("rua",234); put("rt ",160); put("ru ",273); put("sab",458); put("sac",139); put("san",482); put("sas",180); put("sa ",5643); put("Nov",242); put("sha",1745); put("sho",271); put("she",240); put("shi",5099); put("si ",1365); put("siw",355); put("sia",608); put("shw",458); put("shu",187); put("sis",157); put("sin",881); put("sil",283); put("sim",158); put("sik",319); put("sey",212); put("ser",175); put("set",147); put("Okt",259); put("seh",319); put("sen",4083); put("sem",335); put("spa",151); put("son",242); put("su ",198); put("st ",167); put("sko",136); put("ska",599); put("so ",134); put("ssa",198); put("ste",192); put("sta",295); put("sto",444); put("sti",401); put("str",197); put("swa",181); put("tai",280); put("taj",233); put("tak",462); put("tal",339); put("taa",220); put("tab",242); put("taw",344); put("tat",292); put("tar",668); put("tao",3872); put("tan",641); put("tam",288); put("te ",507); put("ta ",6480); put("pa ",765); put("pat",4120); put("pak",235); put("pap",248); put("pam",300); put("pan",895); put("pi ",233); put("ped",156); put("Pap",368); put("pia",789); put("pil",189); put("pin",267); put("pis",162); put("pit",144); put("po ",743); put("pte",287); put("pri",298); put("pwa",189); put("Rai",176); put("ra ",1932); put("ngo",958); put("ngi",1065); put("ngu",1084); put("ngw",363); put("ni ",18823); put("Iri",209); put("nge",937); put("nga",1742); put("Ita",147); put("neo",505); put("nes",161); put("ng ",405); put("nch",2504); put("ne ",911); put("ndu",263); put("ndo",574); put("ndi",1835); put("nde",1085); put("nda",1162); put("nak",251); put("nal",257); put("nam",1855); put("nan",221); put("nao",1457); put("nap",185); put("nac",183); put("nad",288); put("naf",402); put("nai",158); put("naj",196); put("nd ",409); put("nat",353); put("nas",439); put("nay",454); put("na ",15738); put("Jan",271); put("Jam",281); put("nya",1379); put("Jer",215); put("nye",1338); put("nyi",4239); put("nus",133); put("nua",282); put("Jim",174); put("Jin",277); put("nti",403); put("nta",151); put("nte",177); put("nsi",211); put("nsa",4269); put("nt ",232); put("ns ",140); put("nne",236); put("no ",948); put("nji",138); put("nja",269); put("Joh",134); put("nia",4199); put("nis",530); put("ogo",593); put("ois",1291); put("oji",173); put("oja",1149); put("Jul",285); put("Jun",259); put("odo",288); put("of ",150); put("ofu",134); put("ofa",3991); put("oa ",3810); put("oan",188); put("oba",375); put("nza",3817); put("nzi",1111); put("Kai",144); put("Kag",175); put("Kal",167); put("Kan",354); put("Kat",474); put("Kas",372); put("Kar",232); put("Ken",632); put("ozi",165); put("Kis",329); put("Kir",165); put("Kit",204); put("Kin",148); put("Kib",138); put("Kia",309); put("ote",378); put("Kik",287); put("Kil",453); put("Kim",202); put("oto",331); put("Kig",295); put("Kii",249); put("ost",309); put("ota",195); put("ove",320); put("opo",325); put("os ",178); put("or ",161); put("Kon",197); put("orn",300); put("oro",673); put("ore",188); put("ori",369); put("ort",147); put("ora",378); put("ola",427); put("on ",838); put("oli",431); put("ole",357); put("olo",331); put("oka",1580); put("oke",163); put("oko",236); put("oku",141); put("ona",230); put("ond",383); put("one",151); put("ong",860); put("oni",784); put("oma",766); put("omb",303); put("omi",249); put("omo",182); put("op ",143); put("la ",8089); put("le ",1011); put("Kwa",3975); put("laa",157); put("lai",293); put("lak",564); put("lan",660); put("lam",497); put("lat",186); put("lay",3727); put("Kus",393); put("lba",165); put("kuz",236); put("kuw",2713); put("kuu",1305); put("kut",1795); put("kus",492); put("kur",190); put("kup",186); put("kun",409); put("kum",210); put("kul",297); put("kuj",187); put("kwe",591); put("kwa",2512); put("kub",762); put("kuf",233); put("kuh",134); put("kua",620); put("kto",308); put("lom",136); put("loj",136); put("lme",241); put("Lin",225); put("lug",350); put("lu ",155); put("li ",2787); put("lez",192); put("lew",193); put("lev",140); put("les",155); put("leo",178); put("lem",198); put("len",254); put("lek",133); put("lo ",347); put("lla",138); put("lle",153); put("lli",198); put("ll ",147); put("lit",241); put("lis",337); put("lip",257); put("lio",738); put("lin",627); put("lim",922); put("liz",411); put("liy",4415); put("liw",979); put("lic",340); put("lia",1497); put("lik",2742); put("lil",529); put("lih",179); put("lif",397); put("ma ",2611); put("mb ",139); put("maa",449); put("maj",397); put("mak",522); put("mad",206); put("mae",140); put("mag",342); put("mar",439); put("mas",613); put("mal",159); put("mam",161); put("man",1055); put("mat",406); put("mba",3047); put("mbi",361); put("mbe",389); put("mbo",2343); put("me ",516); put("mbu",267); put("mch",170); put("met",211); put("mer",252); put("men",492); put("mfa",152); put("mez",387); put("mfu",373); put("Mei",250); put("Man",216); put("Mar",1940); put("Mas",472); put("Mag",282); put("Mak",206); put("Mac",287); put("Mbe",273); put("mpi",142); put("mon",163); put("moj",1127); put("mpa",160); put("Mor",279); put("mu ",1602); put("mtu",175); put("mto",226); put("Mic",182); put("Mis",147); put("msh",144); put("mta",228); put("mwe",383); put("mwi",345); put("Mko",3178); put("mwa",6205); put("Mku",138); put("Mji",464); put("muj",3839); put("muz",374); put("mhu",232); put("Mtw",147); put("mi ",359); put("mji",5175); put("min",192); put("mil",749); put("Mwa",460); put("mit",295); put("mia",630); put("mik",321); put("mo ",4413); put("mku",1038); put("mko",539); put("mna",1501); put("mmo",145); put("Wik",149); put("Wil",3077); put("Wan",148); put("zwa",252); put("zi ",5785); put("zai",249); put("zaj",254); put("zam",177); put("zan",3194); put("zal",783); put("zar",173); put("zo ",612); put("zia",533); put("zin",815); put("zil",197); put("zik",548); put("zis",240); put("一",303); put("yof",3874); put("yot",286); put("za ",2981); put("ye ",1320); put("yen",237); put("ya ",21762); put("yar",252); put("yan",567); put("yao",167); put("yam",250); put("yak",657); put("yo ",973); put("yin",213); put("yik",3954); put("一一",144); put("Tan",3407); put("Tab",164); put("Shi",315); put("Sin",201); put("Sep",283); put("we ",401); put("wez",265); put("wen",1037); put("wim",286); put("wil",741); put("Sal",197); put("vyo",257); put("wa ",33121); put("wap",4111); put("wan",3901); put("wal",617); put("wam",169); put("wak",9923); put("way",141); put("wat",368); put("war",238); put("was",172); put("wai",2667); put("wah",176); put("vu ",165); put("vya",351); put("vil",200); put("vin",183); put("vit",187); put("vis",284); put("Rom",180); put("vem",244); put("Vij",328); put("uzi",743); put("uza",470); put("Uje",235); put("uwa",2760); put("uvu",174); put("ush",417); put("usi",1319); put("use",183); put("usa",176); put("uu ",2892); put("usu",216); put("ust",207); put("uso",141); put("uti",211); put("ute",137); put("uta",560); put("Uin",218); put("utu",215); put("uto",1436); put("us ",536); put("Ung",252); put("ura",183); put("ure",140); put("uri",491); put("uru",630); put("unz",137); put("Ula",150); put("upa",554); put("upi",311); put("umu",162); put("umi",484); put("umo",2705); put("uma",686); put("umb",661); put("ume",297); put("uo ",238); put("uni",940); put("und",747); put("una",1741); put("ung",1193); put("uku",302); put("uko",457); put("uki",429); put("uka",247); put("ulu",258); put("uli",1405); put("ule",192); put("ula",478); put("ukw",139); put("uhu",267); put("uji",4010); put("uja",302); put("Utu",261); put("ugh",514); put("ufu",352); put("uhi",136); put("ugu",137); put("udi",174); put("ubw",695); put("uch",343); put("ufa",176); put("ufi",189); put("ua ",369); put("uat",317); put("uar",494); put("uan",690); put("uba",185); put("Uch",175); put("ty ",146); put("twa",450); put("tur",369); put("tun",270); put("tum",424); put("Ufa",219); put("ts ",214); put("tu ",896); put("The",164); put("tts",142); put("to ",986); put("tob",268); put("tom",167); put("ton",281); put("tok",1553); put("tol",482); put("tor",246); put("tik",8147); put("tis",158); put("tin",351); put("tio",199); put("thu",171); put("tia",156); put("tem",384); put("ten",273); put("tel",171); put("th ",160); put("ter",432); put("ti ",2389); put("the",225); put("thi",213); put("biw",209); put("bis",191); put("bil",315); put("bin",256); put("bo ",2326); put("bli",173); put("bor",262); put("be ",229); put("bam",230); put("ban",516); put("bal",619); put("bah",147); put("baa",227); put("bab",179); put("bay",333); put("bar",432); put("bao",277); put("bi ",662); put("ber",216); put("bel",151); put("bey",251); put("bia",222); put("ce ",176); put("bu ",4649); put("bru",221); put("bur",149); put("bun",177); put("bwa",786); put("aka",10583); put("am ",337); put("ake",1982); put("aki",644); put("aji",1355); put("aju",170); put("al ",304); put("aja",293); put("ain",393); put("air",222); put("ais",2933); put("aif",267); put("aid",437); put("ahi",308); put("aha",751); put("agh",475); put("agu",395); put("aoi",1233); put("anu",344); put("anz",4756); put("any",4453); put("ano",638); put("ann",141); put("ant",323); put("ans",490); put("ane",261); put("ang",1660); put("ani",7747); put("anj",260); put("ana",4702); put("anc",133); put("and",2300); put("amu",1047); put("amo",1890); put("amp",179); put("amh",222); put("ami",838); put("ame",637); put("amb",1658); put("ama",1868); put("ao ",4649); put("alo",269); put("alm",262); put("all",133); put("ali",5324); put("ale",476); put("ala",1026); put("alb",152); put("an ",1167); put("akr",376); put("aku",502); put("ako",215); put("aba",751); put("abe",140); put("abi",660); put("abo",208); put("abu",582); put("ae ",291); put("aad",302); put("aan",389); put("aal",140); put("aam",185); put("aar",236); put("aa ",361); put("afi",303); put("ai ",477); put("aga",223); put("age",227); put("afu",225); put("aen",162); put("ael",172); put("afa",411); put("ado",269); put("adh",288); put("adi",1538); put("ach",840); put("ada",637); put("azo",205); put("azi",5401); put("aza",186); put("ayo",638); put("aya",4140); put("aye",284); put("ba ",2178); put("are",1998); put("ard",317); put("ara",2057); put("aro",249); put("ari",3153); put("aru",316); put("art",243); put("au ",993); put("asa",1084); put("asi",1169); put("ash",895); put("ask",665); put("ar ",568); put("apa",4869); put("api",162); put("apo",406); put("as ",271); put("aut",148); put("awa",1126); put("awi",190); put("ata",10070); put("ast",167); put("ass",197); put("ato",634); put("ate",225); put("ati",9962); put("ath",135); put("atu",749); }};
    private static final int[] n_words_s = {1316698,1560317,1165243};
    private static final String name_s = "sw";

    public Profile_sw() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
