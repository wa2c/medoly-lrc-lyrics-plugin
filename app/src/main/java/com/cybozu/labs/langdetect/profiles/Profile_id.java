package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_id extends LangProfile {

    private final HashMap<String, Integer> freq_s = new HashMap<String, Integer>(1960) {{ put("D",29898); put("E",10468); put("F",12839); put("G",16234); put("A",46756); put("B",45618); put("C",22345); put("L",19113); put("M",41589); put("N",19093); put("O",9096); put("H",16882); put("I",48750); put("J",24390); put("K",57099); put("U",11179); put("T",39498); put("W",10090); put("V",6089); put("Q",1321); put("P",55685); put("S",65231); put("R",21435); put("Y",7072); put("X",1468); put("Z",2501); put("f",36925); put("g",365165); put("d",485064); put("e",840847); put("b",246328); put("c",70473); put("a",2100570); put("n",996656); put("o",305761); put("l",430448); put("m",362974); put("j",64260); put("k",378208); put("h",280863); put("i",864649); put("w",50622); put("v",31442); put("u",508685); put("t",522270); put("s",482635); put("r",589018); put("q",2068); put("p",245252); put("z",10934); put("y",153007); put("x",3585); put("é",2192); put(" l",29162); put(" m",98895); put(" n",17327); put(" o",22384); put(" h",14754); put(" i",38006); put(" j",15556); put(" k",88933); put(" d",239066); put(" e",8087); put(" f",10185); put(" g",12086); put(" a",116958); put(" b",88325); put(" c",8643); put(" y",62811); put(" z",1713); put(" u",21958); put(" t",81597); put(" w",11107); put(" v",3008); put(" p",104408); put(" s",135289); put(" r",13775); put(" J",23985); put(" K",55803); put(" H",16124); put(" I",42065); put(" N",16611); put(" O",7318); put(" L",17821); put(" M",38172); put(" B",43424); put(" C",19640); put(" A",41294); put(" F",11657); put(" G",14895); put(" D",28065); put(" E",8736); put(" Z",2373); put(" Y",6861); put(" S",61440); put(" R",19599); put(" Q",1212); put(" P",52451); put(" W",9492); put(" V",4735); put(" U",10169); put(" T",36300); put("ا",1474); put("A ",3175); put("Da",7353); put("Co",3999); put("Ce",1371); put("Ch",3483); put("Ci",2915); put("Du",2494); put("Do",1602); put("De",6798); put("Di",6852); put("Fe",1983); put("Fa",1382); put("Er",1543); put("Ge",3292); put("Ga",2686); put("I ",4993); put("Fr",1829); put("Fo",1312); put("Fi",2806); put("C ",1897); put("Au",2055); put("Ar",4506); put("As",2577); put("D ",1256); put("Ba",19721); put("Ag",2188); put("Ab",1488); put("Ac",1714); put("Ad",1447); put("Am",5332); put("An",4093); put("Ap",1629); put("Al",4784); put("Bu",4215); put("Br",3076); put("Ca",4296); put("Bi",2492); put("Be",8472); put("Bo",3000); put("Ku",3549); put("Kr",1685); put("Ko",9825); put("Le",3207); put("Li",3131); put("La",6311); put("Lu",1669); put("Lo",2427); put("Me",8886); put("Mi",3917); put("Ma",15663); put("Mu",4166); put("Mo",3510); put("Ni",1382); put("Ne",3573); put("Na",5130); put("P ",1286); put("Nu",1142); put("No",3476); put("Ok",1174); put("Gr",2085); put("Go",1818); put("Gu",2419); put("Ha",5613); put("He",2039); put("II",2521); put("Hi",2733); put("Ho",2454); put("Hu",2080); put("Ib",1304); put("Ia",3224); put("In",24134); put("Is",3276); put("It",2124); put("Ir",1207); put("Ja",10872); put("Je",6536); put("Jo",2100); put("Ju",3132); put("Ka",22425); put("M ",1852); put("Ki",1891); put("Ke",13666); put("Ut",2746); put("Un",3136); put("Tu",2495); put("Tr",1946); put("To",2609); put("Th",2978); put("Ti",8403); put("Te",9113); put("Ta",6615); put("V ",1165); put("Sy",1338); put("St",3734); put("Su",10264); put("Wo",1285); put("Wi",2707); put("Wa",3162); put("We",1219); put("Vi",1573); put("Pu",4020); put("Pr",10851); put("S ",1994); put("Pe",15767); put("Pa",12458); put("Po",3505); put("Pi",2342); put("Or",1349); put("Se",18572); put("Si",5355); put("Sh",2006); put("Sp",1564); put("So",3044); put("Ru",2528); put("Sa",8331); put("Re",4622); put("Ri",1937); put("SM",1268); put("Ro",3385); put("T ",1420); put("Ra",5456); put("b ",5402); put("a ",312256); put("Ya",1618); put("Yo",2051); put("Yu",2161); put("i ",261146); put("ge",17252); put("ga",100134); put("fi",10254); put("fr",1949); put("fu",1399); put("ft",1686); put("fo",4136); put("he",8947); put("ha",50757); put("gn",2069); put("gl",1807); put("gk",15524); put("gi",27056); put("gh",4457); put("gg",24987); put("gu",19428); put("gs",5762); put("gr",8256); put("go",7739); put("du",22038); put("dy",1437); put("g ",127207); put("ea",8168); put("eb",53877); put("ec",18556); put("ed",14792); put("de",45859); put("dd",1120); put("di",143405); put("do",23309); put("ds",1430); put("dr",3663); put("ew",5523); put("eu",3102); put("ev",3178); put("ey",2387); put("fa",4277); put("h ",162608); put("fe",4040); put("eh",16895); put("eg",14415); put("ef",2165); put("ee",3361); put("el",59121); put("ek",27553); put("ej",8227); put("ei",5982); put("ep",21232); put("eo",11093); put("en",149316); put("em",59371); put("et",34760); put("es",60149); put("er",212475); put("ca",27397); put("e ",42795); put("br",3158); put("bu",59966); put("bo",6681); put("bl",3420); put("bi",20522); put("be",67748); put("da",219838); put("f ",6725); put("cu",3577); put("ct",1798); put("co",4648); put("ck",2674); put("ci",8787); put("ch",7724); put("ce",8123); put("c ",1919); put("az",1822); put("ay",22914); put("ba",74854); put("d ",16186); put("at",148965); put("as",93999); put("ar",156214); put("aw",19383); put("av",2545); put("au",33011); put("ak",85647); put("al",170145); put("ai",50563); put("aj",9897); put("ap",26307); put("am",87049); put("an",494871); put("ac",7825); put("ad",111448); put("aa",15819); put("ab",26392); put("ag",30377); put("ah",179811); put("ae",6490); put("af",4082); put("nu",12849); put("nt",61715); put("ns",21631); put("no",11352); put("nn",7780); put("nz",1307); put("ny",39684); put("oe",1902); put("of",3903); put("oc",2742); put("od",8904); put("oa",2254); put("ob",5836); put("om",19983); put("on",61017); put("ok",11631); put("ol",35874); put("oi",1595); put("og",9163); put("oh",4041); put("ot",23779); put("os",12530); put("ov",13798); put("ou",5529); put("op",9093); put("oo",2776); put("or",39625); put("r ",75373); put("ow",2582); put("oy",1610); put("pe",68224); put("pa",90070); put("pl",2952); put("po",12602); put("ph",1712); put("pi",13857); put("lo",16018); put("ln",1524); put("lm",6776); put("ll",7645); put("ls",1781); put("lu",24730); put("lt",3200); put("ly",1874); put("o ",23320); put("ma",94460); put("mb",26120); put("me",93044); put("ml",1630); put("mi",26777); put("mn",2215); put("mm",2111); put("mp",24012); put("mo",8478); put("mu",28574); put("p ",11473); put("na",77075); put("nc",11437); put("nd",56574); put("ne",39080); put("nf",2387); put("ng",238792); put("ni",56068); put("nj",13796); put("nk",3871); put("ju",15959); put("jo",2256); put("ki",23132); put("kh",4590); put("ke",56774); put("ka",127350); put("m ",50860); put("ky",1397); put("ks",9835); put("kt",10395); put("ku",22809); put("ko",27878); put("kr",3523); put("kk",1592); put("kl",3754); put("km",2765); put("kn",3265); put("li",60829); put("lk",2913); put("le",44927); put("ld",2217); put("la",192799); put("lb",1849); put("n ",334938); put("hr",1702); put("ht",1424); put("hu",19954); put("hk",1872); put("hi",19755); put("hn",2129); put("ho",5306); put("hl",1668); put("id",19549); put("ic",8689); put("ib",13081); put("ia",81624); put("ih",9019); put("ig",10843); put("if",6720); put("ie",7742); put("k ",77693); put("ir",31102); put("is",68271); put("it",40678); put("iu",5028); put("iv",4491); put("iw",2077); put("ij",2865); put("ik",61148); put("il",48904); put("im",30225); put("in",117362); put("io",16681); put("ip",11977); put("je",5678); put("ji",4743); put("iz",1367); put("iy",1200); put("l ",56560); put("ja",34513); put("z ",1416); put("wi",10306); put("wo",1229); put("y ",11456); put("wa",31269); put("we",3398); put("vi",15930); put("vo",1681); put("ve",8269); put("va",3932); put("x ",1658); put("ui",4586); put("uj",4080); put("uk",44283); put("ul",29290); put("ue",2818); put("uf",1241); put("ug",8297); put("uh",9753); put("ur",39636); put("us",36462); put("ut",30979); put("um",25849); put("un",84334); put("up",32836); put("ty",2279); put("tu",61107); put("tt",3054); put("ub",9153); put("ua",56784); put("ud",13238); put("uc",2268); put("w ",1917); put("to",20692); put("tn",2005); put("tl",1402); put("ts",2489); put("tr",20074); put("te",90779); put("tk",2568); put("ti",55141); put("th",5635); put("ta",176003); put("su",25989); put("ss",5417); put("st",32797); put("sy",2246); put("sw",1219); put("sl",3160); put("sk",6158); put("sn",2055); put("sm",3761); put("sp",3394); put("so",6557); put("sc",1962); put("se",100046); put("sh",4276); put("si",103815); put("u ",69102); put("sa",100996); put("rr",2177); put("rs",13384); put("rt",29454); put("ru",41105); put("rv",1161); put("rw",1931); put("ry",4130); put("rp",3731); put("ro",34136); put("rn",12088); put("rm",13211); put("rl",14368); put("rk",15615); put("rj",5203); put("ri",102805); put("rh",3147); put("rg",10415); put("rf",1249); put("re",30519); put("rd",11856); put("rc",2704); put("rb",14366); put("ra",143028); put("t ",74952); put("qu",1325); put("s ",74416); put("pt",3193); put("pu",23123); put("pr",13816); put("ps",1371); put("zi",2204); put("za",3196); put("ye",4611); put("ya",121025); put("yu",3182); put("ys",1566); put("yo",3138); put("yi",2638); put("一",3113); put(" Ga",2665); put(" Ge",3275); put(" Fo",1303); put(" Fr",1822); put(" Fi",2802); put(" Ha",5588); put(" He",2029); put(" Go",1803); put(" Gr",2062); put(" Gu",2405); put(" Ib",1298); put(" Ia",3220); put(" Hu",2077); put(" Ho",2444); put(" II",1738); put(" Hi",2728); put(" Je",6511); put(" Ja",10843); put(" Ir",1206); put(" Is",3262); put(" It",2123); put(" In",24109); put(" Ka",22393); put(" Ke",13629); put(" Ki",1879); put(" Jo",2086); put(" Ju",3129); put(" La",6277); put(" Le",3183); put(" Li",3097); put(" Ko",9805); put(" Kr",1679); put(" Ku",3543); put(" Ma",15603); put(" Mi",3888); put(" Me",8848); put(" Lo",2414); put(" Lu",1657); put(" Ne",3562); put(" Na",5110); put(" Ni",1377); put(" Mo",3486); put(" Mu",4147); put(" Ap",1628); put(" Am",5319); put(" An",4070); put(" Al",4777); put(" Ag",2185); put(" Ac",1711); put(" Ad",1437); put(" Ab",1471); put(" Ba",19679); put(" Au",2049); put(" As",2567); put(" Ar",4490); put(" Be",8434); put(" Bi",2483); put(" Bo",2979); put(" Br",3065); put(" Bu",4209); put(" Ca",4213); put(" Ce",1368); put(" Ci",2897); put(" Ch",3462); put(" Co",3963); put(" Da",7319); put(" Di",6832); put(" De",6775); put(" Do",1546); put(" Du",2487); put(" Er",1536); put(" Fe",1977); put(" Fa",1366); put(" Wo",1267); put(" Wi",2689); put(" We",1211); put(" Wa",3147); put(" Yu",2156); put(" Yo",2043); put(" Ya",1612); put(" Or",1346); put(" Po",3467); put(" Pi",2336); put(" Pe",15730); put(" Pa",12421); put(" Nu",1139); put(" No",3465); put(" Ok",1169); put(" Ra",5409); put(" SM",1160); put(" Ro",3363); put(" Re",4599); put(" Ri",1930); put(" Pr",10827); put(" Pu",4013); put(" Sy",1332); put(" Su",10248); put(" St",3681); put(" Ta",6595); put(" Th",2952); put(" Ti",8388); put(" Te",9090); put(" Tr",1942); put(" To",2586); put(" Ru",2526); put(" Sa",8312); put(" Sh",1982); put(" Si",5333); put(" Se",18549); put(" So",3026); put(" Sp",1555); put(" Vi",1551); put(" Tu",2469); put(" Un",3130); put(" Ut",2746); put(" ja",5269); put(" je",2335); put(" in",24841); put(" il",1562); put(" is",2175); put(" it",1708); put(" ka",17469); put(" kh",1422); put(" ki",3127); put(" ke",41380); put(" ju",6965); put(" ha",6291); put(" gr",1294); put(" gu",1601); put(" ib",1921); put(" ia",3559); put(" hi",4380); put(" hu",2034); put(" ne",5231); put(" na",8812); put(" mu",5887); put(" mo",2739); put(" ol",12623); put(" of",1811); put(" no",1685); put(" le",5736); put(" li",3289); put(" la",14587); put(" ku",3200); put(" km",2201); put(" kl",1852); put(" ko",17290); put(" me",68772); put(" mi",4388); put(" ma",16460); put(" lu",3991); put(" lo",1345); put(" ag",1308); put(" ab",1554); put(" ad",60411); put(" an",11749); put(" ap",1720); put(" ak",5080); put(" al",4506); put(" aw",1213); put(" ar",2749); put(" at",18641); put(" as",3479); put(" ba",29062); put(" bi",8314); put(" be",42050); put(" bo",2101); put(" bu",6066); put(" ca",3227); put(" en",1364); put(" ek",1536); put(" fo",1399); put(" fi",5527); put(" ge",4483); put(" ga",3124); put(" co",1499); put(" ce",1281); put(" da",93500); put(" do",1270); put(" de",28323); put(" di",109723); put(" du",4523); put(" za",1414); put(" ya",62479); put(" ru",1822); put(" sa",30188); put(" se",78628); put(" si",6482); put(" sp",1184); put(" so",1196); put(" ra",4660); put(" re",4944); put(" ro",1171); put(" pu",5843); put(" pr",10257); put(" or",4567); put(" pe",52401); put(" pa",26959); put(" po",5413); put(" pi",2294); put(" wa",3549); put(" wi",6744); put(" tu",4514); put(" ut",3268); put(" um",2172); put(" un",12469); put(" ta",18998); put(" st",3288); put(" su",11745); put(" tr",2305); put(" to",2153); put(" th",1170); put(" ti",9886); put(" te",42313); put("Fil",1716); put("Ger",1344); put("II ",2070); put("Han",1227); put("Har",1306); put("Ing",3276); put("Int",1699); put("Ind",17352); put("Ia ",3146); put("Ara",1730); put("Aus",1437); put("Bah",2306); put("Bal",1493); put("Ban",5008); put("Bar",4958); put("Bat",1605); put("Agu",1534); put("Ame",4085); put("Ang",1356); put("Ber",2116); put("Ben",1538); put("Bel",2649); put("Bri",1173); put("Des",2124); put("Dal",2000); put("Cha",1289); put("Dia",1644); put("Neg",1421); put("Nov",1144); put("Per",8357); put("Pem",1634); put("Pen",3260); put("Pas",1289); put("Par",2408); put("Pad",2035); put("Pan",1988); put("Pul",1756); put("Pro",7786); put("Pre",1253); put("Pol",1113); put("Ita",1993); put("Isl",1234); put("Jan",1394); put("Jak",1458); put("Jep",2416); put("Jer",2596); put("Jaw",4820); put("Jul",1161); put("Kab",8059); put("Kal",5302); put("Kan",1250); put("Kat",1399); put("Kar",2399); put("Ker",1724); put("Kep",1438); put("Kel",1127); put("Kec",4407); put("Kon",1421); put("Kom",1142); put("Kor",1136); put("Kot",4453); put("Lau",1252); put("Men",2499); put("Mer",1254); put("Man",2093); put("Mal",2386); put("Mar",3752); put("Mas",1454); put("Mus",1132); put("Yun",1506); put("一一",1315); put("Sur",1395); put("Sum",1934); put("Sul",1400); put("Sun",2471); put("Sta",2065); put("Ten",4508); put("Tan",2075); put("Sin",1312); put("Ser",4461); put("Sep",1413); put("Sel",5571); put("Sem",1247); put("Seb",1132); put("Rus",1267); put("Sam",1292); put("San",2004); put("Rep",1522); put("Rom",1304); put("Uni",2252); put("Uta",2484); put("Ter",1521); put("The",1859); put("Tim",5598); put("bis",1615); put("bit",1641); put("bil",2430); put("bin",3990); put("bih",2863); put("bli",2292); put("bol",2158); put("ban",15219); put("bak",1477); put("bal",2565); put("bai",2045); put("bag",18039); put("bah",11866); put("bad",2660); put("baw",2021); put("bat",5802); put("bas",2119); put("bar",6280); put("beb",2207); put("bed",1156); put("ber",44372); put("ben",5468); put("bel",6123); put("bek",1139); put("bes",5623); put("bia",3415); put("bid",1129); put("ca ",1339); put("car",5372); put("can",2310); put("cam",11583); put("ce ",2031); put("bu ",2451); put("bua",22699); put("bup",9962); put("bur",1967); put("bul",1642); put("buk",3601); put("bun",4326); put("bum",1823); put("buh",2607); put("but",6527); put("aka",36392); put("am ",27176); put("aki",3783); put("akh",2140); put("al ",32136); put("aja",7514); put("aik",1989); put("ain",9801); put("air",2314); put("ais",1591); put("ait",2311); put("ak ",26644); put("ahk",1403); put("ahi",5150); put("ahu",13410); put("aha",23711); put("agi",8426); put("agu",2010); put("anu",3628); put("any",11108); put("ano",1219); put("ann",4127); put("ant",18067); put("ans",3241); put("ane",1770); put("ang",133187); put("ani",10218); put("anj",5111); put("ank",1863); put("ap ",5145); put("ana",17620); put("anc",4861); put("and",16448); put("amu",2163); put("amp",6554); put("ami",2968); put("ame",2230); put("amb",4802); put("ama",38387); put("alu",3924); put("alo",1291); put("all",1612); put("ali",20004); put("ale",3013); put("ala",101814); put("an ",259764); put("aks",3177); put("aku",4198); put("akt",4736); put("aba",6181); put("abi",1719); put("abu",12017); put("ae ",1556); put("aca",2365); put("aan",12880); put("aat",2166); put("ad ",3820); put("ab ",3122); put("afi",1142); put("ai ",28231); put("aga",15818); put("age",1445); put("aer",3528); put("ah ",131776); put("adi",10057); put("ade",2164); put("ach",1161); put("ace",1304); put("ada",91074); put("ayu",1260); put("aya",17559); put("ba ",1212); put("at ",42706); put("arg",2616); put("are",4682); put("ard",2694); put("ara",50200); put("aro",1477); put("arn",2327); put("arl",1195); put("ark",4616); put("ari",39797); put("aru",4864); put("ars",1240); put("art",10017); put("au ",21880); put("asa",28749); put("ary",2056); put("asi",28272); put("ase",1504); put("ask",2058); put("ar ",23543); put("apa",12599); put("api",3283); put("apu",2004); put("as ",18260); put("aut",2942); put("ay ",1252); put("awa",16458); put("awi",1328); put("ata",52964); put("asu",4212); put("ast",4229); put("ass",1429); put("asy",1183); put("atk",1321); put("ato",2873); put("ate",14253); put("ati",9780); put("aua",1165); put("atu",20191); put("aup",1527); put("aus",1167); put("jen",2753); put("jad",5570); put("jaa",2051); put("jab",1150); put("jar",5491); put("jal",2507); put("jak",2749); put("jan",3425); put("jo ",1155); put("ito",1897); put("itu",7300); put("ism",1635); put("isu",1798); put("ist",11957); put("ita",13383); put("ite",4451); put("iti",3900); put("iwa",1676); put("ium",1147); put("iun",2068); put("ivi",1396); put("ive",2266); put("ipu",1250); put("ipi",1541); put("is ",23018); put("ion",11007); put("ipa",2509); put("ipe",2501); put("ir ",10536); put("irk",1299); put("iri",9503); put("isi",11065); put("ise",5218); put("isa",7947); put("ire",1684); put("ira",4533); put("it ",5451); put("ja ",5112); put("kim",1495); put("kil",1164); put("kin",2100); put("kir",1475); put("kis",1425); put("kit",4346); put("km ",1129); put("ki ",8986); put("khi",1575); put("keb",2854); put("kec",8512); put("ked",2012); put("kek",1191); put("kem",4126); put("kel",7010); put("ken",6683); put("kep",3726); put("kes",1631); put("ker",5150); put("ket",3912); put("ke ",5970); put("ksa",1691); put("ku ",4682); put("kot",9086); put("kon",4219); put("kom",5415); put("kol",2400); put("koh",1184); put("ks ",1167); put("kny",1410); put("kka",1328); put("ko ",1260); put("kla",1828); put("juk",1809); put("jun",1767); put("jum",1474); put("jua",1961); put("jug",4990); put("kaw",1325); put("kat",13174); put("kar",11177); put("kas",4851); put("kap",2757); put("kan",62967); put("kal",5122); put("kam",1705); put("kai",2738); put("kad",1254); put("kab",2943); put("ka ",12884); put("ha ",2059); put("ham",2420); put("han",14832); put("hak",1134); put("hal",1973); put("har",6037); put("has",12725); put("hat",1841); put("haa",1690); put("had",1765); put("he ",2996); put("her",1241); put("hi ",1844); put("hid",1896); put("hin",3929); put("hir",6378); put("hka",1709); put("go ",1252); put("gku",1576); put("gor",1284); put("got",2192); put("gsa",3115); put("gu ",1706); put("gra",2940); put("gri",3408); put("gur",1410); put("gus",2168); put("gun",9840); put("iam",1372); put("ial",6166); put("ian",16893); put("iap",1176); put("ias",3614); put("iat",1370); put("ibi",1510); put("ibu",4263); put("id ",2050); put("iba",3456); put("ibe",2500); put("ia ",44404); put("ier",1178); put("ies",1321); put("ifi",1731); put("ih ",5574); put("ich",1544); put("ie ",1390); put("ica",1838); put("idu",1993); put("idi",3417); put("ide",3199); put("ida",6661); put("if ",2797); put("il ",7886); put("ija",1503); put("im ",3888); put("ika",23689); put("iga",3238); put("igu",3825); put("iha",2592); put("ik ",17419); put("imp",2775); put("ime",1812); put("imi",1994); put("ind",4767); put("ina",9693); put("imu",7350); put("inn",1767); put("ino",1354); put("int",9752); put("ins",11171); put("ine",2698); put("ing",27890); put("ini",22825); put("ink",1199); put("iny",3792); put("iko",1474); put("iki",7614); put("ike",5441); put("ila",14804); put("in ",16335); put("iku",2328); put("ill",2052); put("ilm",5734); put("ili",13211); put("ile",1187); put("ima",9934); put("io ",1907); put("hny",1246); put("hub",1262); put("hun",11971); put("hus",1117); put("fat",1257); put("eta",14851); put("ete",4068); put("eti",4646); put("est",3135); put("esu",1622); put("ess",1214); put("etu",1676); put("evi",1298); put("ey ",1761); put("ewa",3433); put("epe",3912); put("er ",19709); put("epa",9668); put("eor",7717); put("es ",8727); put("ept",1302); put("epu",3274); put("erk",7438); put("erl",11827); put("eri",25792); put("erj",4499); put("erg",3829); put("erh",2837); put("ere",6493); put("erc",1371); put("erd",7020); put("era",35580); put("erb",12574); put("et ",5262); put("esi",21745); put("ese",3800); put("esa",15867); put("eru",21470); put("ert",16167); put("ers",10880); put("ern",7132); put("erm",8938); put("erp",2943); put("ero",2183); put("eki",2304); put("ekn",1342); put("eko",2677); put("eks",2683); put("ekt",2574); put("eku",2083); put("en ",21818); put("ela",27699); put("ele",4883); put("eli",4636); put("ell",1619); put("elo",2885); put("elu",8272); put("emb",14950); put("ema",7624); put("eme",9102); put("emo",1229); put("emi",9424); put("emu",4943); put("emp",7479); put("ene",6504); put("eng",44211); put("ena",14758); put("end",12541); put("enc",3844); put("eni",5826); put("enj",6735); put("enu",4939); put("ens",2961); put("ent",14866); put("eny",6205); put("ege",2018); put("egi",2598); put("ehi",1472); put("ek ",3218); put("ein",1306); put("eja",5845); put("el ",6722); put("eke",1577); put("eka",8278); put("em ",3699); put("gka",11656); put("git",1200); put("gin",2402); put("gio",1293); put("gia",7505); put("gha",1865); put("ggu",3578); put("ggr",3634); put("ggo",2263); put("ggi",3715); put("gga",11266); put("gi ",10809); put("gen",4341); put("ger",4633); put("gem",1548); put("gel",2369); put("ge ",1412); put("gah",5405); put("gai",13025); put("gas",1879); put("gar",10391); put("gat",2080); put("gam",3520); put("gal",5628); put("gan",35620); put("gap",1320); put("ga ",16084); put("for",2821); put("fil",3873); put("fik",2255); put("fis",1267); put("da ",32556); put("de ",5057); put("dak",4551); put("dal",74713); put("dah",2729); put("dae",2768); put("dat",2016); put("das",2265); put("dar",32215); put("dap",6287); put("dan",52470); put("dam",1256); put("day",1876); put("ch ",1540); put("cer",1324); put("cha",1339); put("ck ",1406); put("che",1327); put("chi",1177); put("cil",1660); put("cis",2553); put("ed ",1578); put("eba",14092); put("ebe",8142); put("ebi",3337); put("ebr",1132); put("ebu",26049); put("ea ",1655); put("ei ",1901); put("ega",7504); put("eh ",13927); put("edi",3728); put("ede",1589); put("eda",4173); put("edu",2208); put("eci",1667); put("eca",14054); put("dus",1247); put("don",16622); put("dok",1141); put("dun",4005); put("dup",1272); put("dul",1434); put("duk",5272); put("dua",3278); put("dud",2657); put("dra",1669); put("du ",1319); put("did",3706); put("dia",10670); put("dib",6007); put("der",4755); put("des",7802); put("del",1249); put("dek",2240); put("den",19332); put("dem",1173); put("di ",63731); put("do ",1904); put("dim",2715); put("din",3800); put("dio",1486); put("dip",4666); put("dir",8308); put("dis",11623); put("dit",5425); put("dig",4149); put("dik",8070); put("dil",3331); put("rha",2148); put("rga",5059); put("ri ",42938); put("rge",1577); put("ret",2887); put("res",4698); put("rg ",1147); put("rea",2388); put("rej",1691); put("ren",4953); put("rek",3031); put("rda",4163); put("rdi",3109); put("re ",2800); put("rbu",1584); put("raw",1318); put("rd ",2133); put("rap",3154); put("rar",1749); put("ras",8094); put("rat",11399); put("rbi",1817); put("rba",6850); put("rbe",3317); put("raj",2995); put("rai",2568); put("rah",9741); put("rag",1442); put("ran",36962); put("ram",3611); put("ral",3814); put("rak",7284); put("rab",2762); put("raa",1221); put("raf",1467); put("rad",6359); put("rs ",1283); put("rpe",1250); put("ros",2826); put("rot",1395); put("rom",1135); put("ron",3571); put("rop",2512); put("rov",9832); put("rod",2363); put("rog",1358); put("rny",1495); put("rna",5736); put("rmu",1260); put("ro ",1992); put("rma",9740); put("rle",9267); put("rla",2281); put("rn ",1378); put("rki",1226); put("rke",4730); put("rka",5975); put("rja",3509); put("rip",1275); put("rio",1652); put("rit",4490); put("ris",9168); put("ril",2736); put("rik",14926); put("rin",9510); put("rim",1709); put("ria",5936); put("rib",1211); put("ric",1356); put("rid",1193); put("rie",1621); put("rk ",1641); put("rya",1832); put("ruh",2011); put("rup",16158); put("run",3050); put("rum",2131); put("ruk",1365); put("rus",4704); put("rut",3005); put("ry ",1765); put("rsi",3955); put("rsa",2467); put("rse",3931); put("rta",11752); put("rte",3710); put("rti",7667); put("rua",2111); put("rtu",2198); put("rt ",1478); put("ru ",3013); put("saa",3516); put("sah",3766); put("sai",1253); put("sak",1265); put("sal",14489); put("sam",5305); put("san",11536); put("sat",14608); put("sas",2791); put("sar",11521); put("saw",1247); put("sa ",26535); put("shi",1399); put("si ",37996); put("sid",1884); put("sia",23497); put("sit",3002); put("siu",2036); put("sir",1424); put("sis",6271); put("sin",5946); put("sio",5312); put("sil",3164); put("sim",1558); put("sik",5796); put("sih",1154); put("sif",1869); put("se ",1750); put("ser",7000); put("ses",3161); put("set",3675); put("seh",1426); put("sed",1550); put("sec",2609); put("seb",38986); put("sep",5282); put("seo",6619); put("sen",4315); put("sem",4262); put("sel",6726); put("sek",6032); put("sej",4109); put("spe",1482); put("son",1660); put("st ",1847); put("ss ",1345); put("sli",1139); put("sla",1693); put("ska",2806); put("smi",1231); put("sme",1407); put("sya",1486); put("ssa",1575); put("ste",6115); put("sta",5899); put("sto",1411); put("sti",6848); put("stu",1610); put("str",8471); put("sua",5405); put("sum",1276); put("suk",5658); put("sun",2892); put("sut",1776); put("sus",2249); put("sur",1552); put("tai",3534); put("tak",12396); put("tal",4630); put("tah",16201); put("tab",1684); put("tau",16309); put("tat",1881); put("tas",11773); put("tar",15390); put("tap",2003); put("tan",48487); put("tam",7817); put("te ",2719); put("ta ",30047); put("pa ",5126); put("par",4662); put("pat",19772); put("pas",2458); put("pad",19421); put("pak",16990); put("pal",3741); put("pai",3130); put("pan",11608); put("pi ",3245); put("pen",20640); put("pem",8687); put("per",28237); put("pes",2547); put("pel",2885); put("pil",1386); put("pin",3678); put("pis",1169); put("por",1652); put("pop",1746); put("pos",1337); put("pon",1531); put("pok",1819); put("pol",2768); put("pua",1330); put("pub",1942); put("pte",1271); put("pri",2203); put("pre",1413); put("pro",9219); put("pur",2238); put("pus",1843); put("put",3676); put("pun",4895); put("pul",5693); put("ra ",33891); put("ngo",1466); put("ngi",5434); put("ngk",15500); put("ngu",4341); put("ngs",5639); put("ni ",27725); put("nge",5034); put("ngg",24626); put("ngh",3138); put("nga",45848); put("neg",5658); put("nen",1469); put("ner",3870); put("net",1984); put("nes",16997); put("ng ",124434); put("nci",3629); put("nce",1815); put("nca",3309); put("ne ",3872); put("ndu",6040); put("ndr",1343); put("ndo",17880); put("ndi",8610); put("nde",4365); put("nda",13200); put("ncu",1191); put("nak",8053); put("nal",12498); put("nam",10027); put("nan",12711); put("nar",2327); put("nah",2814); put("nai",1146); put("nd ",3909); put("nat",2083); put("nas",5218); put("na ",14205); put("nya",32061); put("nye",2679); put("nyi",2079); put("nul",1194); put("nun",2161); put("nus",2178); put("nur",1832); put("nua",1507); put("nto",2680); put("ntu",18006); put("ntr",1617); put("nti",5215); put("nta",22900); put("nte",7428); put("nst",1796); put("nse",1390); put("nsi",12613); put("nt ",2342); put("ns ",1443); put("nol",1247); put("nom",2318); put("nny",5115); put("no ",2934); put("nka",1820); put("nja",9105); put("nju",2843); put("nia",6702); put("niv",1591); put("nis",7959); put("nit",2077); put("nin",2190); put("nik",2713); put("ogr",1789); put("ogi",3408); put("ok ",3549); put("ol ",2833); put("ode",3528); put("of ",1858); put("odu",2149); put("oh ",1516); put("obe",1842); put("ote",1332); put("oto",2549); put("ota",16038); put("osi",2975); put("ose",2201); put("oso",1148); put("ovi",10349); put("ove",2391); put("oun",1267); put("ope",1909); put("opa",1279); put("os ",1902); put("opu",1750); put("or ",7039); put("orm",2622); put("oro",1416); put("ord",1550); put("ore",2472); put("org",2231); put("ori",3198); put("ort",1972); put("ora",11685); put("ola",5593); put("on ",12856); put("oli",4593); put("ole",13717); put("olo",5388); put("oka",1673); put("om ",1677); put("oko",1983); put("ona",7292); put("ond",2230); put("one",17406); put("ong",6397); put("oni",2889); put("ono",3029); put("ons",2868); put("ont",3055); put("oma",3069); put("ome",2094); put("omb",1474); put("omi",2626); put("omp",4769); put("omo",1445); put("omu",1988); put("la ",8248); put("le ",2787); put("lah",85384); put("lag",1642); put("lai",7338); put("lal",2146); put("lak",4119); put("lan",18336); put("lam",23788); put("lap",1829); put("lar",2452); put("lat",9794); put("las",5560); put("law",2074); put("lau",6152); put("lay",9124); put("kut",2035); put("kus",1523); put("kur",1949); put("kup",1223); put("kun",2321); put("kum",1981); put("kul",1651); put("kuk",1717); put("kte",1325); put("ksi",4460); put("kua",1980); put("ktr",1281); put("ktu",2650); put("kti",1994); put("kto",2651); put("lok",1231); put("lon",2362); put("lom",2722); put("log",4305); put("lny",1353); put("lmu",1446); put("lua",4860); put("lta",1301); put("lu ",3267); put("li ",7633); put("lev",1141); put("les",2673); put("let",9284); put("ler",1546); put("lem",2195); put("len",2677); put("lek",2289); put("leh",12733); put("leb",3217); put("lla",1957); put("lle",1326); put("lli",1227); put("lka",1991); put("lm ",4360); put("ll ",1780); put("lit",5426); put("lis",7079); put("lir",1515); put("lip",1370); put("lin",6938); put("lim",6542); put("lia",5362); put("lik",11324); put("lih",1781); put("ma ",21495); put("mah",2164); put("mai",3887); put("mak",3420); put("mad",1850); put("mar",3160); put("mas",10730); put("mal",1793); put("man",22564); put("mat",17173); put("mba",10647); put("mbi",2114); put("mbe",6808); put("me ",2693); put("mbu",4891); put("med",1539); put("met",2294); put("mes",1768); put("mer",26378); put("mem",15519); put("mel",4982); put("men",35186); put("luk",2200); put("lui",1193); put("lun",1652); put("lum",2455); put("lus",1551); put("lur",4662); put("mpi",3325); put("mpe",2325); put("mpo",2760); put("mpu",6558); put("mod",1185); put("mon",1666); put("mor",1409); put("mpa",7594); put("mu ",1626); put("mud",2039); put("mua",1660); put("mur",7325); put("mus",3149); put("muk",2006); put("mul",2774); put("mum",2269); put("mun",4790); put("mi ",4545); put("min",4316); put("mil",8646); put("mis",1673); put("mit",1227); put("mia",1700); put("mik",1662); put("mla",1505); put("mny",1911); put("zam",1194); put("yu ",1225); put("ya ",33584); put("yat",1924); put("yar",2043); put("yan",64564); put("yak",4682); put("yah",7474); put("yai",2823); put("yi ",1127); put("wi ",1323); put("wil",6167); put("wa ",9713); put("wan",5957); put("wal",2130); put("wak",2165); put("wat",1765); put("war",3553); put("was",1762); put("wah",1890); put("vin",9845); put("vis",1830); put("ver",3522); put("usi",7004); put("use",1166); put("usa",6560); put("usu",2654); put("ust",3983); put("uti",2003); put("ute",2083); put("uta",7869); put("utu",1851); put("utr",2712); put("us ",12050); put("ut ",11892); put("ura",9315); put("uri",1909); put("urk",1245); put("uru",7051); put("uny",2077); put("upa",26147); put("ur ",13684); put("upu",1725); put("ump",1843); put("umu",2414); put("umi",1414); put("uml",1462); put("umn",1617); put("uma",4069); put("umb",3461); put("ume",1307); put("unt",12867); put("unu",2087); put("uni",6942); put("unc",1388); put("und",1967); put("una",10560); put("ung",21765); put("une",1335); put("up ",3437); put("uks",1606); put("uku",6493); put("uko",1586); put("uki",1626); put("um ",7458); put("uka",7728); put("uju",3230); put("ulu",3880); put("ult",1653); put("uli",4656); put("ula",12496); put("un ",20290); put("uk ",22268); put("ul ",3263); put("ui ",2114); put("uga",6118); put("uha",3495); put("uda",4275); put("udi",2630); put("ubu",2471); put("uh ",4643); put("udu",3551); put("ua ",5771); put("uat",8034); put("uas",4449); put("uar",6223); put("ual",1917); put("uan",9121); put("ubl",2137); put("uba",1945); put("uah",19677); put("ty ",1866); put("tur",4927); put("tus",3183); put("tuj",1345); put("tul",1791); put("tuk",15174); put("tun",2681); put("tum",1823); put("tua",3005); put("ts ",1124); put("tra",8844); put("tri",6158); put("tru",1229); put("tro",2826); put("tu ",22458); put("to ",3427); put("tny",1162); put("tob",1155); put("ton",2911); put("tok",1669); put("tol",2048); put("tor",4842); put("til",2355); put("tik",7507); put("tif",2658); put("tig",1707); put("tit",1315); put("tis",2474); put("tin",8673); put("tim",3584); put("tio",3164); put("tia",2861); put("tid",3087); put("tiv",1124); put("tka",2458); put("tem",9574); put("ten",16531); put("tek",2322); put("tel",6089); put("th ",1540); put("tet",1414); put("tes",1167); put("ter",45895); put("ti ",10357); put("the",1811); }};
    private final int[] n_words_s = {11077227,12709440,9643042};
    private final String name_s = "id";

    public Profile_id() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
