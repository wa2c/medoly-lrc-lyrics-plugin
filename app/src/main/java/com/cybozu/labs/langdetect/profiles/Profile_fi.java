package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_fi extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>() {{ put("D",15745); put("E",23140); put("F",13820); put("G",13964); put("A",40046); put("B",22964); put("C",22892); put("L",28771); put("M",37698); put("N",19249); put("O",13807); put("H",28813); put("I",21256); put("J",16698); put("K",43440); put("U",7805); put("T",36899); put("W",9333); put("V",24290); put("P",38188); put("S",77764); put("R",24157); put("Y",10043); put("X",1821); put("Z",1858); put("f",29615); put("g",68514); put("d",158713); put("e",1194104); put("b",43435); put("c",44492); put("a",1814181); put("n",1349748); put("o",934203); put("l",885783); put("m",433706); put("j",314669); put("k",691662); put("h",239330); put("i",1579260); put("w",11494); put("v",295575); put("u",751889); put("t",1169051); put("s",1099978); put("r",475344); put("q",1633); put("p",248621); put("z",7860); put("y",250687); put("x",8131); put("é",2342); put("ä",426790); put("ö",56679); put("š",2606); put(" l",70812); put(" m",89685); put(" n",43615); put(" o",180629); put(" h",39470); put(" i",21438); put(" j",161666); put(" k",172428); put(" d",8045); put(" e",69090); put(" f",6572); put(" g",3193); put(" a",72510); put(" b",5870); put(" c",2712); put(" y",39165); put(" u",13744); put(" t",117334); put(" v",98965); put(" p",89643); put(" s",126171); put(" r",34331); put(" J",16375); put(" K",41900); put(" H",27293); put(" I",17045); put(" N",17648); put(" O",11538); put(" L",26471); put(" M",33953); put(" B",21331); put(" C",19265); put(" A",36093); put(" F",12406); put(" G",12952); put(" D",13481); put(" E",21275); put(" Z",1697); put(" Y",9517); put(" S",71766); put(" R",22636); put(" P",35182); put(" W",8721); put(" V",22294); put(" U",6908); put(" T",34378); put(" ä",2798); put("A ",2604); put("Da",2655); put("Co",4892); put("Ch",3205); put("Do",1694); put("De",2688); put("Di",2497); put("Fa",1585); put("Eu",3024); put("Et",2349); put("Es",2046); put("En",2950); put("El",2967); put("Ge",2029); put("Ga",2319); put("I ",2891); put("Fr",2159); put("Fo",2415); put("Fi",2245); put("C ",2932); put("Au",2202); put("Ar",3564); put("As",1696); put("D ",1819); put("Ba",4270); put("Am",2679); put("An",4463); put("Al",7577); put("Bu",1605); put("Br",4547); put("Ca",3954); put("Bi",1625); put("Be",3488); put("Bo",2874); put("Ku",5528); put("Ky",1627); put("Kr",2024); put("Ko",6559); put("Le",5504); put("Hä",4384); put("Li",5491); put("La",6972); put("Lu",2444); put("Lo",3355); put("Me",4707); put("Mi",5018); put("Ma",12276); put("Mu",3221); put("Mo",4384); put("Ni",3815); put("Ne",4302); put("Na",2575); put("P ",1899); put("No",3154); put("Gr",2750); put("Ha",6094); put("He",6887); put("II",1871); put("Hi",2221); put("Ho",2925); put("In",4312); put("Is",2133); put("It",2586); put("Ja",4546); put("Jo",4525); put("Ju",3085); put("Ka",13363); put("M ",1871); put("Ki",5554); put("Ke",4172); put("Un",1530); put("Tu",4391); put("Tr",2204); put("To",3873); put("Th",5318); put("Ti",2566); put("Te",3907); put("Ta",5984); put("St",4721); put("Su",13153); put("Wi",2315); put("Wa",2313); put("Vu",2187); put("Vi",4932); put("Va",6002); put("Ve",5654); put("Pu",2910); put("Pr",3317); put("S ",3929); put("Pe",5861); put("Pa",6975); put("Po",6867); put("Pi",3820); put("Se",20320); put("Si",6786); put("Sh",1709); put("So",3993); put("Ru",2993); put("Sa",10443); put("Re",3883); put("Ri",2393); put("Ro",4731); put("Ra",6455); put("b ",4269); put("a ",521046); put("Yh",4604); put("Tä",2310); put("i ",187878); put("ge",9008); put("ga",10572); put("fi",6772); put("fr",2666); put("fo",3746); put("hd",23028); put("he",38383); put("ha",33064); put("gn",1824); put("gl",5520); put("gi",17723); put("gh",2779); put("gu",2320); put("gr",3324); put("go",5014); put("du",5956); put("dy",8630); put("g ",5897); put("ea",17917); put("eb",2211); put("ec",3419); put("ed",14005); put("de",60149); put("di",25899); put("do",15043); put("ds",2160); put("dr",3184); put("ew",1828); put("eu",16676); put("ev",21342); put("ey",5808); put("fa",2058); put("h ",5313); put("fe",3904); put("eh",18148); put("eg",3976); put("ef",1593); put("ee",73047); put("el",141223); put("ek",30007); put("ej",4585); put("ei",64027); put("ep",7092); put("eo",9816); put("en",311708); put("em",29073); put("et",103119); put("es",102393); put("er",103228); put("ca",4693); put("e ",102313); put("br",3098); put("bu",11145); put("bo",3540); put("bl",1718); put("bi",4927); put("be",5208); put("da",16197); put("f ",4183); put("cu",1883); put("ct",2366); put("co",5044); put("ck",6770); put("ci",3249); put("ch",7835); put("ce",5416); put("c ",2562); put("az",1738); put("ay",3699); put("ba",5388); put("d ",12256); put("at",82974); put("as",103098); put("ar",90264); put("av",32524); put("au",43994); put("ak",51088); put("al",188447); put("ai",159817); put("aj",32823); put("ao",2348); put("ap",28311); put("am",44148); put("an",226249); put("ac",6773); put("ad",13018); put("aa",139980); put("ab",3846); put("ag",5956); put("ah",19189); put("ae",6848); put("af",2453); put("nu",19006); put("nt",79878); put("ns",48167); put("nr",2630); put("np",4065); put("no",34422); put("nn",76172); put("ny",10224); put("nv",4829); put("oe",6505); put("of",6585); put("oc",5124); put("od",21394); put("oa",12733); put("ob",3163); put("om",49202); put("on",220535); put("ok",63100); put("ol",88347); put("oi",101083); put("oj",13195); put("og",7134); put("oh",26450); put("kä",31248); put("ot",48882); put("os",73162); put("ov",18707); put("ou",20507); put("op",25063); put("oo",22586); put("or",48012); put("r ",15286); put("ow",2927); put("kö",4127); put("oy",1883); put("pe",39610); put("pa",50151); put("pl",2749); put("po",19855); put("lä",49440); put("ph",2309); put("pi",40558); put("lo",48127); put("lm",34905); put("ll",141072); put("ls",4754); put("lp",5969); put("lv",6764); put("lu",74348); put("lt",40738); put("ly",10157); put("o ",46103); put("ma",107323); put("mb",5971); put("iä",11662); put("me",68275); put("mi",93628); put("mm",26269); put("mp",15152); put("mo",20189); put("mu",39868); put("iö",6377); put("my",13711); put("p ",3699); put("na",88104); put("nc",4077); put("nd",15417); put("ne",115628); put("nf",1558); put("ng",26517); put("nh",5001); put("jä",31523); put("ni",80364); put("nj",4418); put("nk",37841); put("nl",4563); put("nm",4904); put("ju",18610); put("jo",83376); put("ki",95289); put("ke",65747); put("ka",163517); put("m ",8821); put("ky",14212); put("ks",65607); put("kt",5970); put("ku",90075); put("ko",85957); put("kr",5885); put("kk",48142); put("kl",2002); put("kn",1816); put("li",159675); put("hä",6582); put("lk",30410); put("lj",7180); put("le",81668); put("ld",2991); put("la",154382); put("lb",9921); put("n ",656910); put("hr",2420); put("ht",42173); put("hu",10726); put("hj",14036); put("hk",3966); put("dä",2655); put("hi",25267); put("hn",1754); put("ho",13688); put("hl",1555); put("hm",8011); put("id",26485); put("ic",10236); put("ib",2776); put("ia",70345); put("eä",2738); put("ih",17748); put("ig",6859); put("if",2884); put("ie",58968); put("hy",6074); put("k ",7419); put("ir",40208); put("is",262822); put("it",142893); put("iu",5141); put("iv",30487); put("ii",85125); put("ij",23513); put("ik",78594); put("il",97254); put("im",65870); put("in",288307); put("io",39520); put("ip",11864); put("je",25016); put("ji",8870); put("l ",13054); put("ja",144917); put("tä",77533); put("sä",41776); put("vy",5926); put("y ",23865); put("wa",2667); put("rä",7609); put("vi",49369); put("vu",43029); put("vo",19782); put("uv",30695); put("uu",71208); put("ve",29647); put("va",118391); put("x ",5327); put("ui",22148); put("uj",5727); put("uk",45990); put("ul",59174); put("ue",19283); put("ug",2138); put("uh",10868); put("ur",38607); put("us",87239); put("ut",63413); put("um",30283); put("un",78305); put("uo",96118); put("up",18134); put("ty",54901); put("tu",95699); put("tt",139450); put("ub",2312); put("ua",10701); put("ud",16569); put("uc",1658); put("w ",2157); put("to",89637); put("tl",2100); put("ts",24815); put("tr",16390); put("te",142275); put("tk",13593); put("ti",135644); put("th",11168); put("pä",16825); put("ta",258052); put("su",49746); put("sv",13201); put("ss",117492); put("st",215124); put("sy",12228); put("sl",7481); put("sk",39138); put("sn",1670); put("sm",5723); put("sp",7200); put("so",30621); put("sr",2112); put("sc",2341); put("se",139811); put("sh",5275); put("sj",2476); put("si",171906); put("nö",1934); put("u ",38729); put("sa",155918); put("rr",9979); put("rs",10921); put("rt",23316); put("ru",25282); put("rv",12255); put("ry",7951); put("rp",3591); put("ro",37223); put("rn",7182); put("rm",9935); put("rl",3938); put("rk",30938); put("rj",32055); put("ri",107434); put("rh",7195); put("nä",20276); put("rg",6568); put("re",35490); put("rd",7095); put("rc",2086); put("rb",1938); put("ra",66068); put("t ",86930); put("mä",30120); put("s ",74921); put("px",2388); put("py",4209); put("lö",4854); put("pt",2602); put("pu",33575); put("pp",18507); put("pr",6312); put("ps",3220); put("yä",2288); put("yö",17077); put("vä",26642); put("yy",14572); put("yh",29899); put("ye",9120); put("yd",4538); put("ya",1921); put("tö",12963); put("yv",6669); put("yt",27603); put("ys",23779); put("yr",6697); put("yp",4560); put("yn",15218); put("ym",10818); put("yl",20580); put("yk",18251); put("yi",8456); put("ä ",141477); put("äa",1925); put("ö ",8048); put("ää",49135); put("ät",13038); put("äv",12353); put("äy",16618); put("äm",13914); put("äl",20535); put("äo",2938); put("än",46392); put("äp",3824); put("äs",18046); put("är",23375); put("äe",2662); put("äi",25110); put("äh",12610); put("äk",13701); put("äj",7869); put("öö",1835); put("öy",2134); put("öt",2960); put("ör",2049); put("ös",12022); put("ön",8537); put("öl",2694); put("öm",1579); put("ök",3180); put("öh",1825); put("öi",4386); put(" Ga",2281); put(" Ge",2007); put(" Fo",2388); put(" Fr",2153); put(" Fi",2200); put(" Ha",6075); put(" He",6845); put(" Gr",2717); put(" Ho",2907); put(" Hi",2219); put(" Ja",4528); put(" Is",2125); put(" It",2580); put(" In",4291); put(" Ka",13310); put(" Ke",4144); put(" Ki",5524); put(" Jo",4519); put(" Ju",3077); put(" La",6921); put(" Le",5486); put(" Hä",4383); put(" Li",5091); put(" Ko",6537); put(" Kr",2018); put(" Ku",5494); put(" Ky",1626); put(" Ma",12197); put(" Mi",4965); put(" Me",4668); put(" Lo",3341); put(" Lu",2432); put(" Ne",4266); put(" Na",2563); put(" Ni",3790); put(" Mo",4358); put(" Mu",3189); put(" Am",2670); put(" An",4363); put(" Al",7546); put(" Ba",4234); put(" Au",2195); put(" As",1683); put(" Ar",3519); put(" Be",3463); put(" Bi",1601); put(" Bo",2840); put(" Br",4522); put(" Bu",1591); put(" Ca",3824); put(" Ch",3183); put(" Co",4800); put(" Da",2631); put(" Di",2463); put(" De",2676); put(" Do",1656); put(" El",2955); put(" Et",2345); put(" Es",2034); put(" En",2918); put(" Eu",3021); put(" Fa",1558); put(" Tä",2303); put(" Wi",2296); put(" Wa",2289); put(" Yh",4598); put(" Po",6838); put(" Pi",3788); put(" Pe",5834); put(" Pa",6894); put(" No",3136); put(" Ra",6410); put(" Ro",4711); put(" Re",3856); put(" Ri",2382); put(" Pr",3297); put(" Pu",2902); put(" Su",13126); put(" St",4422); put(" Ta",5960); put(" Th",5301); put(" Ti",2528); put(" Te",3868); put(" Tr",2184); put(" To",3832); put(" Ru",2990); put(" Sa",10406); put(" Sh",1689); put(" Si",6699); put(" Se",20290); put(" So",3959); put(" Va",5984); put(" Ve",5638); put(" Vi",4890); put(" Vu",2183); put(" Tu",4371); put(" ja",74622); put(" in",3365); put(" il",6233); put(" is",1907); put(" it",4582); put(" ka",41758); put(" ki",21829); put(" ke",20426); put(" jo",60523); put(" ju",13868); put(" ha",11651); put(" he",10326); put(" hy",3213); put(" ih",2463); put(" hi",4639); put(" ho",2199); put(" hu",2999); put(" jä",12144); put(" ni",12782); put(" ne",5502); put(" na",3130); put(" my",11678); put(" mu",27269); put(" mo",4701); put(" ol",30354); put(" om",3788); put(" on",110013); put(" kä",15552); put(" oh",5375); put(" oi",2526); put(" of",2700); put(" ny",2745); put(" nu",2351); put(" no",7612); put(" le",7943); put(" hä",3832); put(" li",11414); put(" n ",4861); put(" la",17994); put(" ku",35062); put(" ky",5412); put(" kr",3070); put(" ko",26681); put(" me",12340); put(" mi",8054); put(" ma",22033); put(" lu",14733); put(" ly",2009); put(" lo",4509); put(" am",2608); put(" an",4850); put(" ai",10388); put(" aj",3176); put(" al",26047); put(" av",3055); put(" au",2714); put(" ar",5107); put(" as",8761); put(" er",7980); put(" et",8124); put(" es",9200); put(" en",13349); put(" ei",4106); put(" el",17426); put(" fi",2104); put(" de",3555); put(" di",1711); put(" ed",3633); put(" vä",7263); put(" ym",1774); put(" yl",9242); put(" yk",6097); put(" yh",19431); put(" tä",4808); put(" ru",4569); put(" ry",2522); put(" sa",23518); put(" se",22713); put(" si",27049); put(" so",8389); put(" ra",14800); put(" re",3082); put(" ri",4303); put(" nä",4180); put(" ro",4580); put(" pu",9566); put(" pr",4112); put(" s ",2297); put(" px",2387); put(" py",2739); put(" mä",2284); put(" os",9956); put(" ot",1666); put(" ov",7670); put(" op",3466); put(" or",1769); put(" pe",20224); put(" pa",14359); put(" po",10381); put(" pi",14437); put(" lä",10166); put(" sä",4588); put(" va",34158); put(" ve",7508); put(" uu",2456); put(" vo",6724); put(" vu",30542); put(" vi",12396); put(" ty",5276); put(" tu",19858); put(" us",4512); put(" ur",1664); put(" ul",2520); put(" ta",38855); put(" sy",5905); put(" st",3683); put(" su",25086); put(" to",18439); put(" th",5224); put(" pä",9746); put(" ti",8862); put(" te",13642); put(" ää",2036); put("Ete",1912); put("Eur",2720); put("For",1614); put("Hel",2818); put("Int",2022); put("Alb",1684); put("Bri",2185); put("Nor",1531); put("Per",1731); put("Par",1783); put("Poh",2941); put("Ran",1941); put("Kal",1586); put("Kan",2320); put("Kau",1621); put("Kar",2566); put("Kir",1567); put("Kun",1618); put("Hän",3486); put("Mar",3439); put("ään",18825); put("ääk",4426); put("äät",2724); put("äär",4190); put("ääs",2129); put("ää ",10320); put("Vuo",2097); put("Yhd",3250); put("Suo",9477); put("Sta",1658); put("Sen",4830); put("äht",3405); put("ähd",1555); put("ähe",3536); put("ähi",1621); put("Ruo",1578); put("änn",2773); put("äns",2545); put("änt",2999); put("Sak",1930); put("ämi",2674); put("äni",2131); put("äjä",6711); put("äne",3700); put("Se ",11672); put("äs ",1575); put("ämä",7782); put("äos",2009); put("äka",1964); put("äis",10749); put("äin",8551); put("äiv",1941); put("ält",2814); put("äli",6173); put("älk",2158); put("äll",6310); put("äks",2395); put("äki",2767); put("än ",27597); put("äve",2052); put("ävi",2773); put("ärä",1957); put("äyt",13595); put("äri",6126); put("ärj",7258); put("ät ",5667); put("äsi",4968); put("äse",2119); put("ärv",3216); put("äst",3327); put("äss",3767); put("ätt",2038); put("ävä",6336); put("Ven",3558); put("Val",1869); put("The",3947); put("Tur",1761); put("ber",2683); put("ce ",2305); put("bri",1634); put("bum",8758); put("aka",6269); put("ake",7201); put("aki",5604); put("aji",6912); put("ajo",3036); put("al ",4672); put("aja",18366); put("aje",2029); put("aih",3713); put("aik",14735); put("ail",13159); put("aim",1862); put("ain",38398); put("ais",49469); put("ait",14001); put("aiv",4010); put("aid",2730); put("ahm",1834); put("aht",3966); put("ahd",4670); put("aha",3293); put("anu",4220); put("ano",5725); put("ann",13433); put("anm",2516); put("ant",14494); put("ans",18785); put("ane",3551); put("ang",3334); put("anh",3197); put("ani",13808); put("anj",1817); put("ank",6571); put("ana",14302); put("anc",1814); put("and",6936); put("amm",4533); put("amo",2056); put("amp",3132); put("ami",8254); put("ame",4479); put("ama",17130); put("alv",4153); put("alu",15472); put("alt",16363); put("alo",7802); put("alm",6123); put("all",43431); put("alk",10647); put("ali",18156); put("ale",9704); put("ala",40225); put("alb",7609); put("an ",106763); put("aks",12179); put("aku",8003); put("akt",1737); put("ako",3232); put("akk",5053); put("ae ",1542); put("aaj",5209); put("aak",5208); put("aai",4807); put("aan",46070); put("aal",13155); put("aam",4542); put("aas",4039); put("aar",7457); put("aav",4444); put("aat",11110); put("aa ",30258); put("ai ",13611); put("ael",1895); put("adi",4196); put("ack",1788); put("ada",3189); put("at ",26536); put("arh",2305); put("are",4235); put("ard",3175); put("ara",7612); put("arp",1607); put("aro",2059); put("arm",2145); put("arl",1651); put("ark",11086); put("arj",11397); put("ari",15453); put("aru",3626); put("arv",4834); put("arr",3315); put("ars",2606); put("art",6849); put("asa",4886); put("asi",8287); put("ase",5553); put("aso",1854); put("ask",4888); put("ar ",2391); put("apa",10451); put("ape",2308); put("api",2097); put("app",6574); put("apu",2355); put("as ",6418); put("ava",19468); put("aut",8391); put("avo",2634); put("avi",5086); put("avu",2827); put("ata",7640); put("asu",5324); put("ast",26494); put("ass",30398); put("asv",4804); put("atk",3390); put("ato",4227); put("ate",6056); put("ati",12192); put("att",13242); put("ats",1884); put("atu",3704); put("aul",4866); put("aup",10709); put("aur",1674); put("aus",6854); put("aud",2731); put("auh",2050); put("auk",3794); put("jel",4529); put("jen",8431); put("jes",7295); put("jet",1556); put("ji ",2297); put("jaa",5054); put("jat",4403); put("jas",4641); put("jal",7569); put("jak",4713); put("jan",11104); put("jai",10124); put("jou",4303); put("joh",4795); put("joe",2427); put("jol",3356); put("jok",24849); put("joi",16729); put("jon",9520); put("jot",6559); put("jos",6649); put("jia",1786); put("itk",2090); put("ito",6246); put("itu",9149); put("itt",43813); put("its",13426); put("ity",9715); put("isk",6128); put("ism",2973); put("isl",1855); put("iso",4721); put("isp",1964); put("iss",30541); put("isu",9410); put("ist",90841); put("isy",1690); put("ita",17408); put("ite",16460); put("iti",5058); put("ivo",1659); put("ivu",2547); put("isä",6664); put("iva",11789); put("ivi",6748); put("ive",3576); put("ipp",2283); put("ipu",1889); put("ilä",2764); put("ilö",2966); put("is ",8294); put("ion",10934); put("iop",2837); put("ios",4401); put("iot",1986); put("ikä",1979); put("ioi",3973); put("iol",2452); put("ipa",1808); put("ipe",1630); put("irt",2993); put("iro",1572); put("irk",4448); put("iri",6484); put("irj",10801); put("isi",26753); put("ise",59209); put("isa",5742); put("ire",2058); put("inä",3666); put("ira",5520); put("it ",5916); put("ja ",90836); put("itä",10709); put("ivä",3912); put("kii",3407); put("kik",3240); put("kij",2090); put("kim",2775); put("kil",12288); put("kia",4204); put("kie",9439); put("kiv",2180); put("kin",14280); put("kio",1639); put("kir",13427); put("kis",5163); put("kit",6283); put("ki ",12342); put("kea",4096); put("kee",4463); put("keh",4191); put("kei",5212); put("kem",2757); put("kel",5236); put("ken",9401); put("kes",10316); put("ker",7027); put("keu",3655); put("ket",2834); put("kev",1653); put("ke ",2125); put("kre",1700); put("ksa",4741); put("kse",20115); put("ku ",3951); put("kot",3952); put("kou",3762); put("kos",5488); put("kor",5268); put("koo",4082); put("kon",11074); put("kom",3392); put("kol",7289); put("kok",7259); put("koj",1821); put("koi",14746); put("koh",3422); put("koe",1980); put("kku",3944); put("kke",3841); put("kka",15414); put("kko",10268); put("kki",11721); put("ko ",7803); put("jul",11521); put("kat",4283); put("kau",16540); put("kar",4289); put("kas",12031); put("kap",6608); put("kan",20757); put("kal",9712); put("kam",1710); put("kak",4624); put("kah",2946); put("kai",21386); put("kaa",14665); put("ka ",40830); put("ha ",1581); put("han",4990); put("hai",2275); put("hal",6945); put("har",4587); put("hah",1631); put("haa",1766); put("he ",6389); put("hdo",2167); put("hdy",6548); put("hde",8081); put("hdi",4168); put("hel",4032); put("hei",7575); put("hee",1552); put("het",1965); put("her",2750); put("hen",6953); put("hem",2103); put("hin",8148); put("his",2803); put("hit",5065); put("hja",5248); put("hje",3366); put("hjo",5005); put("gle",2192); put("gla",2321); put("gra",1797); put("ial",8370); put("ian",13283); put("ias",7499); put("ic ",1670); put("iaa",4991); put("ia ",28344); put("iet",9042); put("iel",9758); put("iem",2939); put("ien",20960); put("ier",2897); put("ies",3794); put("ied",2257); put("ieh",1857); put("iek",1604); put("eä ",1619); put("ich",1751); put("ie ",2310); put("ica",1971); put("idi",2094); put("ide",16311); put("ida",3705); put("iid",1915); put("iik",12079); put("iih",2036); put("iin",34905); put("iil",1871); put("iim",1601); put("iis",3357); put("iir",7370); put("iip",1650); put("iiv",3159); put("iit",11463); put("ija",15115); put("ijo",3212); put("ika",17282); put("ii ",2634); put("igh",2049); put("ihe",3769); put("iha",1816); put("ihm",2273); put("ihi",4976); put("iht",1902); put("imo",4420); put("imm",10403); put("imp",1982); put("ime",14110); put("imi",21669); put("ind",1904); put("ina",17571); put("imu",3688); put("inn",9244); put("ino",7309); put("int",21117); put("ins",3814); put("ine",62207); put("ijä",3525); put("ing",10847); put("ini",7961); put("ink",6694); put("ioa",2138); put("inu",2993); put("inv",2235); put("iko",8699); put("ikk",20680); put("iki",6034); put("ike",7607); put("ila",13660); put("in ",123439); put("iku",7225); put("iks",5910); put("ilp",4235); put("ilo",6040); put("ill",27290); put("ilm",11405); put("ilj",1888); put("ili",8485); put("ile",2304); put("ima",7267); put("io ",5938); put("ilt",4359); put("ilu",7728); put("hmä",2450); put("hol",1937); put("hon",2485); put("hoi",2109); put("hmi",2965); put("hmo",1850); put("hty",9392); put("htu",3085); put("hto",2163); put("hti",9794); put("hte",8765); put("hta",4518); put("htä",1902); put("huo",1796); put("hum",3543); put("hyv",1693); put("etä",4989); put("evä",1690); put("eta",9667); put("ete",9398); put("eti",3164); put("est",38413); put("ess",23541); put("eud",1841); put("eto",4814); put("etr",5809); put("ets",2385); put("ett",36313); put("etu",5501); put("ety",2077); put("erä",4263); put("eve",1697); put("eva",7898); put("evi",4106); put("euv",2196); put("eut",3244); put("eur",5135); put("eus",2033); put("esä",2111); put("ey ",1541); put("evy",4434); put("elä",9755); put("er ",8358); put("eor",2097); put("eol",1627); put("emä",1894); put("es ",8151); put("erk",7307); put("eri",25262); put("erg",2239); put("erh",1625); put("enä",7730); put("ere",5494); put("era",4710); put("et ",16346); put("esk",9110); put("esi",14483); put("ese",2664); put("erv",1561); put("eru",10609); put("err",4242); put("ert",7186); put("ers",4983); put("ern",2916); put("erm",2674); put("ero",5460); put("eki",2975); put("ekk",1967); put("ekn",1637); put("eko",1843); put("eks",9087); put("ekt",2330); put("en ",216998); put("ela",5301); put("ele",9915); put("eli",28185); put("elj",2641); put("elm",10985); put("ell",36182); put("elo",8595); put("elu",6803); put("els",2931); put("elt",10887); put("ely",1692); put("ema",7235); put("eme",2562); put("emm",5417); put("emo",1546); put("emi",5347); put("emp",2813); put("ene",8165); put("eng",2981); put("ena",5955); put("end",1729); put("enn",9973); put("enk",6752); put("eni",7989); put("ens",15471); put("ent",18077); put("ekä",5887); put("ehd",2924); put("ehi",4544); put("eht",6057); put("eis",18168); put("eim",3841); put("eil",7078); put("ein",8482); put("eik",4720); put("eid",4335); put("eja",2716); put("el ",2656); put("eit",8348); put("öss",1852); put("gis",3146); put("gin",6890); put("gia",4299); put("ght",1865); put("ös ",7736); put("gen",2252); put("ger",1575); put("ön ",5342); put("gas",2278); put("gan",2134); put("fri",1576); put("for",2137); put("fil",1743); put("da ",1964); put("de ",3246); put("daa",2346); put("dal",1725); put("das",2350); put("dan",3795); put("ck ",3175); put("ed ",1799); put("ean",1991); put("eal",1781); put("eat",2428); put("ea ",2811); put("ei ",3830); put("een",37770); put("eel",9070); put("ees",6176); put("eet",6503); put("edi",2493); put("ede",4270); put("edu",2200); put("edo",1603); put("ee ",9590); put("dys",6375); put("dus",2698); put("don",2736); put("dol",2034); put("dos",3976); put("dia",2516); put("der",2863); put("des",8657); put("det",3714); put("del",8280); put("dek",2312); put("den",24947); put("dem",1603); put("di ",1662); put("din",5138); put("dio",5021); put("dis",6234); put("rhe",3181); put("rha",2376); put("näj",3467); put("näk",2091); put("näi",1855); put("ri ",14183); put("rgi",2577); put("ret",2238); put("res",3703); put("nä ",7166); put("rea",2509); put("ree",2885); put("rei",4803); put("ren",6049); put("rel",2990); put("rdi",1756); put("re ",2848); put("rd ",1882); put("ras",4899); put("rat",4668); put("rau",3008); put("raj",2533); put("rai",2122); put("ran",13051); put("ral",4384); put("rak",6377); put("raa",6078); put("rad",3325); put("rs ",1794); put("ros",3755); put("rot",3070); put("rom",2805); put("ron",4039); put("roo",4243); put("rov",1686); put("roc",2312); put("roi",1996); put("rna",1810); put("rne",1656); put("rni",2033); put("ro ",2723); put("rma",3198); put("rme",1785); put("riä",3343); put("rmi",2119); put("rko",8356); put("rki",6693); put("rkk",7003); put("rke",4145); put("rka",1913); put("rjo",6361); put("rja",16764); put("rje",7814); put("rio",2073); put("rit",12816); put("ris",12311); put("rii",3347); put("ril",5111); put("rik",9617); put("rin",19152); put("rim",2324); put("ria",8783); put("ric",1741); put("rie",2399); put("näy",2474); put("ruo",2205); put("run",2801); put("ruu",3504); put("rus",12209); put("rva",2385); put("rvi",3707); put("rve",3560); put("rvo",2466); put("ry ",2410); put("rsi",3925); put("rta",4520); put("rto",3696); put("rte",2990); put("rti",3436); put("rtt",1850); put("rt ",1812); put("rro",1797); put("rre",2394); put("rra",3831); put("saa",11689); put("sai",4605); put("sak",3935); put("sal",8568); put("sam",4120); put("san",10417); put("sat",2386); put("sas",5453); put("sar",9940); put("sav",3217); put("sa ",88364); put("ryh",2885); put("si ",33316); put("siv",2877); put("sie",3768); put("sia",14727); put("sit",13812); put("sis",15595); put("sin",22898); put("sio",5975); put("sil",7537); put("sim",10671); put("sij",10631); put("sik",6439); put("sii",15427); put("se ",7339); put("sev",3309); put("ser",1954); put("ses",19353); put("set",8009); put("seu",4708); put("sei",5713); put("see",16044); put("sen",44413); put("sem",6469); put("sel",8992); put("sek",9571); put("spa",2113); put("sot",3315); put("sol",2285); put("son",3580); put("sop",1591); put("sos",3124); put("sod",2739); put("sof",1780); put("soi",4463); put("st ",1959); put("sli",1829); put("sla",3001); put("ski",7594); put("sko",4863); put("sku",10246); put("ska",6718); put("ske",7078); put("sma",1538); put("siä",2875); put("smi",2339); put("ssä",20775); put("stä",20839); put("stö",6003); put("syn",3354); put("syy",2751); put("sse",2037); put("ssa",81782); put("sso",2391); put("ssi",7227); put("ste",34759); put("sta",74007); put("sto",18448); put("sti",27582); put("stu",19044); put("str",3547); put("sty",7941); put("suk",6559); put("suo",12490); put("suu",15921); put("sut",2418); put("sva",8410); put("svi",2330); put("tai",23079); put("taj",9294); put("tak",4197); put("tal",15729); put("taa",33105); put("tav",11283); put("tau",2602); put("tat",3910); put("tas",5911); put("tar",15686); put("tap",4732); put("tan",13725); put("tam",13647); put("te ",4200); put("ta ",96137); put("pa ",1685); put("par",4524); put("paa",2641); put("pah",2670); put("pak",1785); put("pal",14678); put("pai",9231); put("pan",6844); put("läp",1604); put("län",3940); put("läm",2523); put("läi",5398); put("läh",6121); put("pi ",2782); put("lä ",21592); put("per",21853); put("pet",1794); put("pel",8616); put("lää",3392); put("pia",3590); put("pid",1828); put("pie",3232); put("pii",5873); put("pil",2184); put("pin",5017); put("pis",5110); put("pit",5090); put("por",1632); put("poi",2560); put("poh",4180); put("pol",4180); put("ppu",2417); put("ppi",4768); put("ppa",7267); put("ppe",1921); put("pro",3960); put("pur",1783); put("pus",1680); put("pun",10901); put("puo",7107); put("pul",1657); put("puh",2589); put("px ",2372); put("puu",2017); put("mä ",7257); put("mäi",6703); put("män",3876); put("mäs",1650); put("mää",5076); put("ra ",5712); put("ngi",7939); put("ngl",4558); put("ni ",6341); put("nge",2486); put("nga",3203); put("jän",3177); put("jäl",4462); put("jäs",2729); put("jär",9906); put("nha",2067); put("nei",4215); put("nel",5383); put("nen",63104); put("ner",2732); put("net",11819); put("nes",5079); put("neu",1692); put("ng ",3916); put("nee",7398); put("jä ",5912); put("nce",1684); put("ne ",6951); put("ndo",1777); put("ndi",2475); put("nde",2171); put("nda",1665); put("nak",1691); put("nal",6875); put("nan",9972); put("nai",6761); put("naa",4824); put("nd ",4059); put("nat",3023); put("nas",6250); put("na ",39872); put("myö",9305); put("iö ",2528); put("ntä",3484); put("nsä",4958); put("nva",1615); put("num",1758); put("nus",3629); put("nut",8387); put("nty",5978); put("nto",10581); put("ntu",4377); put("ntt",4440); put("nti",13349); put("nta",21023); put("nte",11336); put("nso",2855); put("nss",4946); put("nse",1616); put("nsi",11891); put("nsk",3706); put("nsa",12409); put("nnä",1593); put("nt ",1924); put("ns ",1897); put("nol",2730); put("noi",8508); put("nom",2361); put("non",3636); put("not",1919); put("nos",4123); put("nne",16039); put("nna",31714); put("nno",6361); put("nni",12231); put("nnu",4777); put("nme",1667); put("nma",1873); put("jää",2989); put("nla",2791); put("no ",2124); put("nke",2631); put("nki",13461); put("nka",13056); put("nko",2285); put("nja",2100); put("nii",4930); put("nie",2772); put("nia",6492); put("nis",11071); put("nit",5273); put("nim",13793); put("nin",16562); put("nik",3354); put("nil",2835); put("ogi",4118); put("oi ",3679); put("oht",5278); put("käs",5110); put("kär",1779); put("ohj",13237); put("oho",2246); put("oiv",1619); put("ois",23808); put("oir",1655); put("oit",25419); put("oin",13137); put("oik",5181); put("oim",14211); put("oil",4642); put("oih",1702); put("oid",5498); put("käy",11169); put("oje",6434); put("oja",5307); put("ock",3160); put("ode",9371); put("odi",1977); put("odo",4669); put("of ",2718); put("oda",3354); put("oel",2434); put("oen",2647); put("ofi",1682); put("kä ",7989); put("oa ",4765); put("oal",3299); put("nyk",2547); put("nyt",4401); put("nvä",1760); put("otu",2486); put("otk",3192); put("oti",5562); put("ote",5798); put("ott",10457); put("ots",2991); put("oto",4571); put("ost",14630); put("ota",8496); put("osi",11836); put("osk",3907); put("ose",3031); put("oss",12304); put("oso",3047); put("ovi",3135); put("ova",10956); put("ove",2498); put("ouk",4542); put("oul",4682); put("oun",1887); put("ous",2951); put("out",1762); put("opp",4159); put("opi",5727); put("ope",4607); put("opa",3651); put("os ",5287); put("opu",2089); put("oon",7289); put("ool",1601); put("oom",1672); put("or ",1961); put("oot",2091); put("oos",2166); put("oop",3454); put("ork",3647); put("orm",3104); put("orn",1628); put("oro",2190); put("ord",2513); put("ore",3159); put("org",2171); put("ori",12794); put("osa",15087); put("ort",3782); put("ot ",3256); put("ora",3303); put("ola",6203); put("on ",146201); put("oli",32153); put("oll",16426); put("ole",10977); put("kää",1980); put("olt",1744); put("olm",4749); put("olo",5842); put("oly",2026); put("olu",4176); put("oka",27584); put("okk",2554); put("oki",3937); put("oke",2183); put("oks",6588); put("oko",8846); put("oku",9166); put("ona",6281); put("one",7607); put("ong",1915); put("oni",10795); put("onk",9689); put("onn",20892); put("ono",2022); put("ons",4191); put("ont",4754); put("oma",18393); put("ome",15724); put("omi",7452); put("omu",1601); put("la ",45674); put("le ",23672); put("laa",8510); put("lah",2594); put("laj",7083); put("lai",41589); put("lal",1802); put("lak",2624); put("lan",15670); put("lam",1915); put("lat",4073); put("las",9219); put("lau",6037); put("lbu",8824); put("kuv",12915); put("kuu",20315); put("kut",5564); put("kus",5968); put("kup",2448); put("kuo",2056); put("kun",18716); put("kul",5464); put("kuk",1991); put("ksi",34515); put("kso",2000); put("kue",1696); put("kui",3945); put("kti",3367); put("kyi",1827); put("kyl",5052); put("llä",17871); put("lok",9030); put("lon",3666); put("lom",4409); put("lop",2359); put("log",4285); put("loi",6423); put("lpa",4160); put("los",4127); put("lot",1540); put("lou",2403); put("ljä",2124); put("lmi",8971); put("lme",5378); put("lma",14737); put("lti",5458); put("ltt",2378); put("lue",13574); put("lsi",2865); put("lta",20774); put("lu ",5034); put("lmä",3813); put("hän",3427); put("li ",38792); put("lev",10595); put("les",3513); put("let",2489); put("ler",1630); put("lem",3429); put("len",7655); put("lek",2031); put("lel",2977); put("lei",7201); put("leh",3152); put("lee",7823); put("llu",3725); put("lo ",3012); put("lla",45545); put("lle",23098); put("lli",38165); put("llo",8003); put("lko",3906); put("lku",3582); put("lka",14232); put("lke",3142); put("lki",3385); put("ljo",1577); put("lje",1833); put("ll ",2046); put("lit",6604); put("lis",35039); put("lip",2086); put("lio",3340); put("lin",25643); put("lim",2511); put("liv",3460); put("lia",6855); put("lik",3266); put("lil",3081); put("lii",12989); put("lij",5839); put("lie",2208); put("ma ",15016); put("mb ",3008); put("maa",25280); put("mah",1595); put("mai",6076); put("mak",3049); put("mar",3413); put("mas",6492); put("mal",15003); put("man",17338); put("mat",9985); put("me ",2801); put("mee",1671); put("met",10390); put("mes",9381); put("mer",13701); put("mel",4799); put("men",18334); put("mei",2490); put("iä ",10723); put("lve",3316); put("lvi",1540); put("luk",6577); put("lui",2536); put("luo",7753); put("lun",5262); put("lut",6301); put("lus",6284); put("luv",9141); put("luu",4990); put("ltä",6950); put("lyh",1732); put("lym",1752); put("mpi",5319); put("moo",2276); put("mon",6257); put("mpa",1715); put("mmä",7757); put("mpä",2564); put("mua",1679); put("mus",7282); put("mut",3853); put("muu",6734); put("mui",3639); put("muk",6397); put("muo",5752); put("mi ",13252); put("min",18710); put("mil",5082); put("mis",25017); put("mit",6945); put("mia",4076); put("mie",6732); put("mik",3016); put("mii",3025); put("mo ",3241); put("mmi",7415); put("mma",5671); put("mme",2557); put("väl",6253); put("vä ",5493); put("vää",1811); put("vän",2110); put("vät",4019); put("yvi",1744); put("yty",2014); put("ytt",9230); put("yte",5446); put("ysv",6099); put("yst",4193); put("ysi",1754); put("yri",2968); put("yt ",5088); put("ymä",1567); put("ys ",5219); put("ylä",5863); put("yny",2515); put("yvä",4334); put("yyl",1824); put("yys",2076); put("yyp",2141); put("yyt",1690); put("yy ",2993); put("ye ",3730); put("yde",2513); put("yee",3728); put("yks",11428); put("yky",3192); put("yn ",4172); put("yle",4657); put("yli",5834); put("yll",2070); put("ymi",2202); put("ymp",3885); put("yne",1918); put("ynt",3210); put("yi ",2699); put("yhm",2893); put("yhd",7827); put("yht",15566); put("yis",3850); put("tön",2023); put("tös",1710); put("tö ",2585); put("täm",6823); put("tän",1885); put("täh",1876); put("täj",3398); put("tä ",34022); put("tää",13926); put("täy",1596); put("tär",1635); put("täv",7438); put("sää",2844); put("sä ",25127); put("säl",3359); put("säk",2119); put("säv",1927); put("vuo",32425); put("vun",2514); put("vul",3123); put("vy ",2051); put("via",2642); put("vio",1556); put("vir",4221); put("vil",2731); put("vin",6040); put("vii",6538); put("vie",4226); put("vit",3912); put("vis",7340); put("voi",10127); put("von",1808); put("vos",2863); put("räi",2223); put("vi ",2985); put("ver",6645); put("ves",2270); put("ven",5385); put("vel",7217); put("ve ",1928); put("val",26751); put("vak",1862); put("van",11048); put("vap",1548); put("var",8953); put("vat",20575); put("vas",8886); put("vaa",7863); put("vai",7839); put("va ",18614); put("uuk",1525); put("uun",9740); put("uul",10457); put("uud",5759); put("uus",11398); put("uur",9061); put("uut",11944); put("uvi",3760); put("uvo",2424); put("uva",18498); put("uvu",5385); put("usl",2474); put("usk",5912); put("usi",8604); put("use",5829); put("usa",2048); put("uu ",9094); put("ust",26922); put("uss",6964); put("utk",3663); put("uti",2698); put("ute",5204); put("uta",9377); put("utt",14676); put("uts",1830); put("utu",7065); put("uto",3590); put("us ",19751); put("ut ",13926); put("ura",6710); put("ure",2812); put("urh",2266); put("uri",10072); put("uro",4160); put("uru",1961); put("uod",11474); put("uon",20919); put("uol",10441); put("uom",19569); put("uok",4826); put("uot",13021); put("uor",5597); put("uos",6389); put("upe",2549); put("upu",10042); put("umi",12508); put("uma",5258); put("umb",3567); put("ume",3010); put("unt",10189); put("unu",3435); put("unk",6506); put("uni",5890); put("unn",17239); put("und",1617); put("una",4707); put("ung",5391); put("une",2125); put("uks",15716); put("uku",7377); put("uko",2518); put("ukk",6046); put("uki",2552); put("uke",1610); put("um ",2055); put("uka",8994); put("ulu",17346); put("ult",3742); put("ulo",2329); put("ull",6128); put("ulk",14188); put("uli",3634); put("ule",2174); put("ula",6501); put("un ",17537); put("uin",4870); put("uis",6404); put("uht",1985); put("uhu",1855); put("uje",1776); put("uit",1991); put("uja",2763); put("ui ",2881); put("uha",2389); put("ude",10287); put("udi",3267); put("ue ",4574); put("uet",2172); put("uee",7376); put("työ",3659); put("ua ",4041); put("uas",1855); put("tyv",3209); put("tyy",6164); put("tye",7861); put("tyi",5279); put("tyk",3846); put("tym",2979); put("tyn",4512); put("tys",6857); put("ty ",6437); put("tur",3509); put("tus",10527); put("tut",5144); put("tuu",8595); put("tuv",3012); put("tuj",1880); put("tui",4969); put("tul",5059); put("tuk",7469); put("tun",13048); put("tum",4274); put("tuo",5296); put("tua",2491); put("tud",2510); put("ttö",2890); put("ttä",18426); put("tra",3772); put("tri",7061); put("tro",3179); put("tu ",15401); put("tsa",2112); put("tse",11636); put("tsi",5021); put("tsu",1775); put("tta",37250); put("tte",15326); put("tti",29985); put("tto",7420); put("ttu",17456); put("tty",9077); put("to ",10851); put("tiö",3363); put("toj",3671); put("toi",21414); put("tkä",1786); put("toa",3897); put("tos",4171); put("tot",2445); put("tom",3430); put("ton",10160); put("tok",5162); put("tol",5536); put("tor",8049); put("too",2936); put("top",1727); put("tii",20914); put("til",10225); put("tik",4482); put("tie",14185); put("tit",2814); put("tis",9101); put("tin",13829); put("tim",2695); put("tio",13178); put("thu",3317); put("tia",5511); put("tiv",2672); put("tki",4098); put("tka",4817); put("pää",9932); put("tem",2906); put("ten",19694); put("teo",3855); put("tei",13515); put("tek",5492); put("tel",25974); put("tee",16061); put("teh",4545); put("th ",1573); put("tet",23609); put("tes",1638); put("ter",13778); put("ti ",27214); put("pär",2295); put("the",3039); put("päi",2568); put("yön",1725); put("yös",8569); put("yöh",1625); put("yä ",1547); }};
    private static final int[] n_words_s = {15184556,16912812,13033049};
    private static final String name_s = "fi";

    public Profile_fi() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
