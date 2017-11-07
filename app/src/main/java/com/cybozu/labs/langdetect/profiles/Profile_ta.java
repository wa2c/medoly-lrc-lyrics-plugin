package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_ta extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>(2249) {{ put("D",612); put("E",464); put("F",392); put("G",381); put("A",1033); put("B",541); put("C",1226); put("L",485); put("M",882); put("N",489); put("O",332); put("H",425); put("I",870); put("K",359); put("T",782); put("W",287); put("V",311); put("P",878); put("S",1046); put("R",508); put("f",1073); put("g",1998); put("d",2759); put("e",8290); put("b",1281); put("c",2926); put("a",10092); put("n",6488); put("o",5986); put("l",4436); put("m",3185); put("k",952); put("h",3181); put("i",7588); put("w",661); put("v",857); put("u",3410); put("t",6374); put("s",4316); put("r",6588); put("p",2229); put("y",1574); put("x",422); put("ித ",544); put("ில ",698); put("ிய ",7880); put(" m",283); put(" o",562); put(" d",292); put(" a",454); put(" c",438); put(" t",733); put(" p",559); put(" s",429); put(" r",341); put(" K",344); put(" H",326); put(" I",509); put(" N",361); put(" L",347); put(" M",788); put(" B",464); put(" C",741); put(" A",832); put(" F",341); put(" G",361); put(" D",414); put(" E",381); put(" S",843); put(" R",426); put(" P",727); put(" T",657); put("ாங்",593); put("ாசி",571); put("ாகி",1226); put("ாகு",5727); put("ாகா",403); put("ாக்",2294); put("ாகக",726); put("ாகப",554); put("ாகம",1267); put("ாகவ",971); put("ாகங",337); put("ாகத",594); put("ானி",1010); put("ாந்",804); put("ாநி",2007); put("ானத",779); put("ாப்",821); put("ான்",1998); put("ாடு",3023); put("ாட்",5816); put("ாடல",810); put("ாடி",363); put("ாடக",761); put("ாத்",727); put("ாண்",1485); put("ாதம",306); put("ாது",396); put("ாதா",507); put("ாதி",637); put("ாணப",442); put("ாணத",365); put("ாஸ்",323); put("ிங்",711); put("ிச்",643); put("ிசை",617); put("ிடி",332); put("ிடப",478); put("ிடம",356); put("ிடத",463); put("ய",68757); put("ம",127919); put("ன",81690); put("ந",46905); put("ப",128120); put("த",166688); put("ண",25132); put("ாரா",410); put("ாரி",765); put("ா",101548); put("ி",184542); put("ஸ",4761); put("ஹ",1196); put("ார்",5370); put("ழ",21652); put("வ",79830); put("ஷ",1166); put("ர",109358); put("ற",58813); put("ல",91486); put("ள",62504); put("ஏ",2039); put("எ",16082); put("ஊ",889); put("உ",10751); put("ஈ",845); put("இ",32538); put("ஆ",19361); put("அ",23958); put("ஃ",562); put("ாறு",598); put("ஞ",2219); put("ட",101059); put("ாலத",613); put("ஜ",3516); put("ச",50507); put("ங",15929); put("ாலம",447); put("ாற்",1321); put("க",197565); put("ஒ",11957); put("ஓ",1288); put("ஐ",1009); put("ாயக",290); put("ாமல",357); put("ாமி",434); put("b ",301); put("ாம்",1576); put("ோ",14983); put("ொ",17674); put("ை",61878); put("்",437238); put("ௌ",348); put("ூ",11561); put("ாயி",304); put("ு",185888); put("ீ",8590); put("ே",20308); put("ெ",21142); put("ாரண",513); put("a ",854); put("ாரத",304); put("ாய்",1383); put("ாரம",364); put("ிகா",518); put("ாவட",2380); put("ாவத",750); put("ாவர",299); put("ிகை",370); put("ிக்",6769); put("ாழ்",1243); put("ிகோ",462); put("ாவி",3762); put("ாவா",383); put("ாலு",670); put("ாலி",445); put("ாளர",1347); put("ால்",3272); put("ாலை",675); put("ாளா",324); put("ாளி",348); put("ிகள",3325); put("ிகழ",507); put("ாள்",696); put("ிகப",373); put("i ",647); put("ினை",666); put("ge",282); put("ினி",620); put("ga",286); put("ினா",801); put("ினர",628); put("ினம",287); put("ிந்",854); put("he",687); put("ha",472); put("g ",377); put("ea",314); put("ec",300); put("ed",390); put("de",481); put("di",495); put("ிப்",4537); put("h ",377); put("el",404); put("en",840); put("em",293); put("et",386); put("es",700); put("er",1464); put("ின்",17928); put("ca",348); put("e ",1989); put("da",327); put("f ",407); put("ct",322); put("co",377); put("ch",435); put("ce",352); put("ியே",373); put("ியூ",340); put("ிரத",942); put("ியு",993); put("ிரம",574); put("ியோ",394); put("ியை",838); put("ிரப",448); put("ியவ",789); put("ியல",3188); put("ியர",810); put("ியி",4273); put("ியா",6620); put("ியத",1203); put("ிமு",497); put("d ",748); put("at",1135); put("as",419); put("ியம",1215); put("ar",1055); put("ியன",1057); put("ிமை",522); put("ியப",743); put("ியக",532); put("al",1246); put("ai",378); put("ap",295); put("am",828); put("an",1637); put("ac",346); put("ad",343); put("ிமா",411); put("nt",654); put("ns",302); put("of",412); put("om",409); put("on",1256); put("ol",463); put("ிடை",404); put("ou",276); put("or",868); put("ிட்",1455); put("ிடு",635); put("r ",1101); put("pa",374); put("lo",330); put("ll",406); put("o ",326); put("ma",480); put("mb",415); put("me",406); put("mi",333); put("na",737); put("nd",662); put("ne",446); put("ng",642); put("ni",455); put("ித்",3054); put("m ",787); put("ிணை",304); put("ிண்",482); put("li",572); put("le",592); put("ிதி",409); put("la",866); put("n ",1450); put("ht",310); put("hu",372); put("hi",390); put("ic",779); put("ia",502); put("ig",354); put("is",617); put("it",600); put("il",395); put("in",1071); put("io",687); put("l ",875); put("ிஸ்",689); put("y ",837); put("ve",327); put("x ",278); put("ur",632); put("us",340); put("um",519); put("un",283); put("tt",320); put("to",401); put("tr",385); put("te",756); put("ti",1167); put("th",985); put("ta",522); put("st",661); put("se",294); put("si",396); put("rt",301); put("ro",534); put("ri",933); put("re",684); put("ra",1084); put("t ",1022); put("ீடு",326); put("ீட்",724); put("s ",1609); put("ிரி",3610); put("ிரா",1282); put("ிர்",1294); put("ிறப",627); put("ிரை",1621); put("ிரே",484); put("ிறந",629); put("ிறத",2122); put("ிரு",4047); put("ிறா",398); put("ிறி",463); put("ிறு",1338); put("ிலங",466); put("ிலம",1354); put("ிற்",1776); put("ிலத",1747); put("ிலா",649); put("ிலு",1997); put("ிலி",1089); put("ில்",23900); put("ிலை",1645); put("ிலே",416); put(" த",26595); put("ிழக",839); put(" ய",1289); put(" ம",33424); put(" ப",40065); put(" ந",18582); put("ிழம",471); put("ிழர",540); put(" வ",24461); put(" ல",1016); put(" ர",1685); put("ிளை",610); put(" ஸ",454); put(" ஹ",795); put(" ஈ",841); put(" உ",10726); put(" ஊ",885); put(" எ",15892); put(" ஏ",2016); put(" அ",23901); put("ிழி",439); put(" ஆ",19313); put(" இ",32484); put(" ச",22093); put("ிவந",792); put(" ஜ",2159); put(" ட",1284); put(" ஐ",986); put(" ஓ",1277); put(" ஒ",11946); put(" க",32960); put("ிவர",337); put("ிழ்",3205); put("ிவம",324); put("ிவி",1334); put("ிவா",521); put("ிவு",1106); put("ீதி",457); put("ீர்",719); put("ீன்",337); put("ுச்",849); put("ுங்",895); put("ீவு",404); put("ீழ்",360); put("ுக்",10659); put("ுகழ",319); put("ுகி",3737); put("ுகா",398); put("ுகள",4206); put("ுட்",1213); put("ுடை",558); put("ுடி",1579); put("ுடு",653); put("ுடன",1030); put("ுநா",474); put("ுனி",297); put("ுபட",358); put("ுந்",3187); put("ுன்",993); put("ுனை",280); put("ுப்",4254); put("ுது",799); put("ுதி",3266); put("ுண்",554); put("ுதல",2039); put("ுதப",476); put("ுதன",363); put("ுத்",6198); put("ுரி",516); put("ுரு",740); put("ுரை",511); put("ுறி",2453); put("ுறு",308); put("ுறை",2894); put("ுற்",571); put("ுளா",391); put("ுளி",404); put("ுள்",6921); put("ுமை",377); put("ுமு",342); put("ுமா",937); put("ும்",36442); put("ுரம",392); put("ுவை",304); put("ுவி",1320); put("ுவா",2204); put("ுவர",1344); put("ுவம",286); put("ுவன",802); put("ுவத",1697); put("ுழு",744); put("ூடி",578); put("ூட்",652); put("ூன்",565); put("ூரா",577); put("ூரி",517); put("ூர்",1687); put("ூறு",472); put("ூலம",428); put("ூற்",526); put("ூல்",531); put("ூலி",289); put("அக்",419); put("அதி",733); put("அதன",471); put("அணி",287); put("அணு",326); put("அடி",812); put("அப்",365); put("அன்",299); put("அனை",343); put("ஆகி",979); put("ஆகு",4632); put("ஆக்",285); put("அழை",700); put("அவர",558); put("ென்",1743); put("அல்",2972); put("அளவ",598); put("ெப்",657); put("அரு",474); put("அறி",1258); put("அமெ",613); put("அமை",3884); put("அரச",1350); put("அம்",318); put("ெண்",620); put("ஆங்",1422); put("ெட்",778); put("ெடு",671); put("ஆசி",448); put("ஆண்",2706); put("ஆட்",480); put("ஆம்",1544); put("ைய ",1236); put("ஆய்",339); put("ஆரம",608); put("ஆறு",307); put("ஆற்",386); put("இக்",380); put("ஆவத",1054); put("ஆவா",643); put("ேயே",307); put("ேட்",292); put("இங்",400); put("இசை",860); put("ேண்",284); put("இடத",337); put("ேதி",335); put("இடம",403); put("இடை",433); put("இத்",877); put("இது",3256); put("ேசி",564); put("ேசு",307); put("ேசப",275); put("இணை",776); put("இதன",761); put("இந்",4776); put("ெயர",1260); put("ெயற",334); put("ெயல",776); put("இப்",496); put("இன்",581); put("ெர்",351); put("ெறு",383); put("ெய்",2021); put("ெரி",1478); put("ெரு",1277); put("இயற",542); put("இயல",277); put("ெல்",969); put("இம்",396); put("இரண",675); put("ெளி",2069); put("இயக",775); put("ெற்",1979); put("இயங",307); put("இலக",714); put("இலங",1277); put("இரு",3631); put("இரா",2331); put("இவ்",582); put("இவை",339); put("இவர",1304); put("ைப்",5756); put("இல்",712); put("ையை",1039); put("ையே",430); put("ையத",341); put("ையா",3283); put("ையி",4758); put("ையு",2157); put("ையம",618); put("ைமை",414); put("ைத்",2427); put("ைந்",3238); put("ைநக",408); put("ைச்",1529); put("ேளம",371); put("ேளக",469); put("ேற்",1275); put("ேலி",402); put("ேலு",410); put("ேர்",1922); put("ேறு",768); put("ேரூ",552); put("ேரி",362); put("ைக்",5944); put("ேவை",525); put("ைகள",3265); put("்க ",1447); put("ைவு",308); put("ைவி",438); put("ைவர",377); put("ொன்",519); put("்ப ",344); put("ோக்",753); put("ொள்",838); put("ொழு",386); put("ொழி",2875); put("ொல்",850); put("ொலை",513); put("ொற்",349); put("்ள ",4240); put("ொரு",2529); put("்ற ",3387); put("்ட ",3672); put("ொகு",770); put("ொண்",2337); put("ொது",899); put("்த ",5466); put("ொடு",300); put("ொடங",359); put("ொடர",1238); put("ோப்",332); put("ோன்",1334); put("ோயி",659); put("ோர்",868); put("ோரி",632); put("ோரா",279); put("ோவி",367); put("ோட்",1097); put("ோடு",420); put("ோது",603); put("்கை",2757); put("்கோ",938); put("்கொ",643); put("்க்",1264); put("்கூ",637); put("்கு",14044); put("்கெ",383); put("்கே",554); put("்கா",4646); put("்கி",8271); put("்கள",15575); put("்கல",1350); put("்கர",1200); put("்கவ",322); put("்கப",3910); put("்கம",1458); put("்கத",1249); put("்கண",471); put("்கட",610); put("்கங",350); put("்சா",888); put("்சி",4832); put("்சு",884); put("்சை",360); put("எல்",437); put("எழு",1211); put("எடு",356); put("எண்",595); put("எதி",426); put("எனப",826); put("என்",8881); put("்தா",3028); put("்து",12325); put("்தி",19739); put("்த்",1974); put("்தோ",339); put("்தொ",367); put("்தை",2288); put("்தத",1008); put("்ணி",349); put("்தம",644); put("்தப",1133); put("்தன",629); put("்தவ",959); put("்தர",950); put("்தல",971); put("்பை",508); put("்பே",287); put("்பெ",966); put("்போ",717); put("்பொ",819); put("்பி",4248); put("்பா",4739); put("்பூ",376); put("்பு",5441); put("்ப்",1248); put("்பந",489); put("்னை",343); put("்பன",396); put("்னி",1023); put("்னா",524); put("்பட",14770); put("்னு",1025); put("்பத",6302); put("்பவ",714); put("்பம",709); put("்பர",1317); put("்நி",304); put("்நா",1754); put("்பக",746); put("்னர",478); put("்ந்",2122); put("்டத",3858); put("்டன",373); put("்டப",375); put("்டம",1689); put("்டர",578); put("்டங",415); put("்ச்",1088); put("்தக",679); put("்ட்",1036); put("்டோ",535); put("்டை",1115); put("்டு",8476); put("்டி",5785); put("்டா",1951); put("்டவ",480); put("்வை",282); put("்வத",502); put("்வர",423); put("்வி",886); put("்வா",1151); put("்வு",876); put("்வே",640); put("்ஸ்",867); put("்மா",564); put("்மன",338); put("்யு",285); put("்மை",1050); put("்மு",410); put("்யப",368); put("்ளத",1941); put("்லு",367); put("்லூ",277); put("்லி",796); put("்லா",1037); put("்றை",756); put("்ளா",277); put("்ளி",589); put("்ளன",998); put("்லை",579); put("்றா",2083); put("்றி",2742); put("்று",6173); put("்லத",2780); put("்றழ",440); put("்றவ",489); put("்றம",405); put("்றல",286); put("்றத",1488); put("்றன",1215); put("ஐக்",380); put("ஏற்",808); put("ஊர்",281); put("உரி",362); put("உரு",1122); put("உறு",409); put("உலக",903); put("உயி",570); put("உயர",401); put("உள்",3206); put("உதவ",285); put("உண்",440); put("என ",651); put("மக",2002); put("மங",313); put("மத",1505); put("மண",816); put("மட",614); put("மன",2412); put("யல",4462); put("யற",1277); put("யர",2780); put("யவ",955); put("ரக",668); put("ரச",2387); put("ரங",785); put("ரட",422); put("யா",11572); put("யு",3982); put("யூ",642); put("ரண",1624); put("யி",11562); put("யீ",287); put("ரத",2928); put("ரப",1866); put("யே",1284); put("ரன",414); put("யை",1942); put("ரம",3652); put("ய்",4254); put("யோ",852); put("மய",595); put("மம",514); put("மற",2418); put("மர",1631); put("மல",1338); put("யக",1931); put("யங",868); put("மா",15034); put("மி",8348); put("மீ",1286); put("மு",9054); put("மூ",1942); put("யத",2022); put("மெ",1524); put("மே",3645); put("மை",8679); put("யன",3058); put("யப",1368); put("மொ",2460); put("மோ",314); put("ம்",59753); put("யம",2603); put("பங",437); put("னவ",812); put("பக",2737); put("னல",278); put("னர",2255); put("னம",1302); put("ந்",20330); put("நோ",770); put("னப",1121); put("பன",834); put("னை",2914); put("னே",371); put("பந",774); put("பத",7767); put("பண",1265); put("னு",2330); put("னி",5915); put("னா",2676); put("பட",17323); put("னக",412); put("நவ",322); put("நல",298); put("நே",639); put("நெ",1117); put("நு",803); put("நீ",1405); put("னத",1823); put("நூ",1307); put("நி",7179); put("னட",305); put("நா",7474); put("னங",575); put("ப்",34661); put("பொ",3990); put("போ",3721); put("பல",2780); put("பள",417); put("பழ",657); put("பவ",1066); put("னோ",401); put("பம",782); put("ன்",48370); put("பய",2032); put("பர",3306); put("பற",996); put("பூ",994); put("பே",2341); put("பெ",6101); put("பை",873); put("பி",11022); put("பா",9941); put("பு",9453); put("பீ",476); put("தை",3979); put("தோ",1044); put("தொ",4546); put("தே",2805); put("தெ",1540); put("த்",34813); put("தழ",321); put("தவ",1763); put("தூ",638); put("தீ",1160); put("து",39998); put("தா",7230); put("தி",33129); put("தப",1845); put("ணை",1673); put("தன",4207); put("தந",348); put("தத",1637); put("தள",614); put("தல",4546); put("தற",1613); put("தர",2410); put("தய",384); put("ண்",13361); put("தம",6359); put("நட",1795); put("நக",2290); put("ட்",26642); put("டோ",698); put("டே",309); put("டை",5277); put("டெ",379); put("டு",23773); put("டி",13483); put("தட",432); put("ணா",409); put("ணி",3340); put("ணு",927); put("தக",1336); put("ணவ",477); put("தங",477); put("ணம",1051); put("ணர",362); put("ணத",619); put("ணப",596); put("ணக",587); put("ணங",275); put("ாக",19861); put("ாங",594); put("ாச",1598); put("ாஜ",510); put("ாட",11489); put("ாத",4020); put("ாண",3622); put("ான",10191); put("ாந",3098); put("ாப",1499); put("ார",8693); put("ாற",2311); put("ாம",3725); put("ாய",2982); put("ிக",14337); put("ாழ",1765); put("ாவ",8717); put("ால",7588); put("ாள",3674); put("ாஸ",333); put("ிங",712); put("ிச",2403); put("ிஞ",334); put("ித",5697); put("ிண",920); put("ிட",5029); put("ிம",2804); put("ிந",1298); put("ிப",5786); put("ின",22037); put("ிள",1636); put("ிழ",6094); put("ீக",398); put("ிவ",5662); put("ிய",32313); put("ிர",16244); put("ிற",8462); put("ில",35051); put("ீட",1354); put("ிஸ",713); put("ீச",331); put("ீத",858); put("ீன",904); put("ுக",21093); put("ீழ",591); put("ீவ",685); put("ீர",1646); put("ுட",5430); put("ுங",895); put("ுச",1183); put("ஸ்",4460); put("ஹா",281); put("வந",1310); put("வன",1956); put("ழை",1756); put("வப",343); put("வர",10633); put("வம",1198); put("ழ்",5992); put("வள",1206); put("வழ",1620); put("வற",1169); put("வல",1808); put("வக",1767); put("வச",597); put("வங",465); put("ழி",4553); put("வட",4450); put("ழா",328); put("வத",5184); put("வண",714); put("ழு",3446); put("வெ",3428); put("வே",3105); put("வை",3927); put("வோ",475); put("வ்",1486); put("ங் ",289); put("வா",8141); put("வீ",991); put("வி",15999); put("வு",6267); put("ஷ்",653); put("ரோ",1002); put("றப",1173); put("ரை",4461); put("றன",1468); put("ர்",31916); put("றம",626); put("றத",3830); put("ரூ",812); put("ரு",27373); put("ரீ",451); put("ரே",1017); put("றந",763); put("ரெ",389); put("றங",282); put("ரா",8822); put("ரி",12841); put("ரல",936); put("ரள",279); put("ரர",859); put("றக",313); put("ரவ",1332); put("லப",708); put("லய",334); put("லம",3186); put("ற்",17148); put("லர",750); put("று",11549); put("லத",5640); put("றை",4508); put("றா",2833); put("றி",8018); put("றல",363); put("றழ",451); put("லக",2902); put("றவ",909); put("லங",2178); put("ளர",1895); put("ல்",45274); put("ளம",1268); put("லோ",710); put("ளப",432); put("ளன",1049); put("லை",8052); put("லே",726); put("ளத",2348); put("லூ",633); put("லு",4434); put("லா",5224); put("லி",6034); put("ளங",419); put("ளக",843); put("லவ",809); put("ழர",599); put("ழல",340); put("ள்",22645); put("ழம",740); put("ளை",6098); put("ளி",11162); put("ளு",3887); put("ளா",3042); put("ழங",730); put("ழக",1857); put("ளவ",1419); put("எழ",1223); put("எல",532); put("கமா",1059); put("கம்",3148); put("என",11165); put("எட",532); put("எண",597); put("எத",529); put("கரத",596); put("கரம",753); put("கரா",588); put("கரு",1925); put("கரி",702); put("கரை",390); put("கர்",1591); put("ஊர",477); put("கற்",356); put("கலை",1083); put("உய",994); put("உர",1677); put("உற",823); put("உல",1062); put("உள",3281); put("கலா",280); put("கழக",436); put("கல்",1081); put("களை",4493); put("கள்",9772); put("களி",6714); put("களா",1687); put("ஈழ",284); put("களு",3253); put("உட",908); put("உத",494); put("உண",848); put("இம",448); put("கழ்",778); put("இந",4780); put("இன",1053); put("இப",504); put("இவ",2571); put("இய",2152); put("இர",7002); put("இற",478); put("இல",3110); put("கவி",404); put("கவல",360); put("இட",1530); put("இண",833); put("இத",5637); put("இங",400); put("இச",1168); put("ஆய",571); put("ஆம",1554); put("ஆற",784); put("ஆர",1083); put("ஆவ",1949); put("இக",392); put("கவு",1099); put("ஆன",368); put("ஆப",334); put("ஆட",604); put("ஆண",2834); put("ஆங",1423); put("அவ",1452); put("ஆச",513); put("அர",2426); put("அம",5128); put("ஆக",6177); put("அழ",1041); put("அள",802); put("அல",3618); put("அற",1466); put("அந",302); put("அப",488); put("அன",910); put("அண",903); put("அத",1978); put("அட",1678); put("அச",379); put("அக",783); put("ஃப",444); put("காண",1037); put("காத",305); put("காட",1197); put("காக",926); put("கிப",294); put("கிர",1793); put("கிற",2778); put("கிய",4454); put("கிழ",1101); put("கில",2584); put("கிள",303); put("டங",1551); put("டக",2338); put("ஞர",411); put("ஞ்",1568); put("கான",927); put("டம",3786); put("காப",476); put("டப",1246); put("டன",1702); put("காம",341); put("கார",1102); put("கால",2029); put("டத",5604); put("கிக",280); put("காவ",696); put("டா",3183); put("கிட",434); put("டவ",894); put("டற",287); put("டல",2022); put("கின",3040); put("டர",1996); put("குள",472); put("குர",499); put("குற",3053); put("ஜன",765); put("கும",15556); put("குழ",660); put("குவ",564); put("கூட",1198); put("ஜெ",307); put("ஜி",368); put("ஜா",311); put("குக",975); put("கீழ",409); put("ஜூ",479); put("குட",1461); put("குப",912); put("குத",3019); put("சட",699); put("சந",447); put("சன",838); put("சத",750); put("ங்",15912); put("சம",2542); put("சர",1035); put("சப",743); put("சல",387); put("சீ",884); put("சு",4739); put("சா",3736); put("சி",12172); put("சை",2278); put("செ",5006); put("சே",2116); put("கூற",724); put("சூ",935); put("ச்",6667); put("சோ",703); put("சொ",1085); put("கெட",300); put("சக",830); put("சங",473); put("க்",40970); put("கைப",322); put("கோ",3746); put("கொ",4347); put("கே",1313); put("கை",5279); put("கைய",1982); put("கெ",595); put("கைக",801); put("கூ",2267); put("கு",33794); put("கீ",677); put("கி",19030); put("கா",10953); put("கவ",2505); put("கொல",275); put("கொள",837); put("கொண",2252); put("கொட",399); put("கம",4718); put("கர",7242); put("கற",456); put("கல",3250); put("கள",26914); put("கழ",1431); put("கன",1126); put("கப",5340); put("கட",3472); put("கத",3423); put("கண",2578); put("கக",1180); put("கச",448); put("கங",1149); put("ஒன",2135); put("க்க",31923); put("ஒர",8154); put("கோர",492); put("கோய",755); put("கோவ",374); put("ஓர",763); put("கோட",700); put("ஒல",300); put("ஒள",283); put("கோண",286); put("ஏற",1035); put("ஐக",383); put("க்ட",361); put("சக்",631); put("்ட",31792); put("்த",54197); put("்ண",1523); put("am ",356); put("்ந",4822); put("்ப",46615); put("்ன",4757); put("்க",63255); put("்ச",10386); put("al ",518); put("ோம",420); put("ோய",1038); put("ோர",2106); put("ோற",374); put("ோல",725); put("ோவ",577); put("ோட",1840); put("ோப",835); put("ோன",1596); put("ோத",1196); put("ோண",311); put("ொர",2700); put("ொற",791); put("ோச",380); put("ொழ",3265); put("ோக",1274); put("ொல",1580); put("ொள",880); put("ொட",2489); put("ொன",573); put("ொண",2347); put("ொத",1247); put("ொக",1140); put("and",321); put("an ",334); put("்வ",6141); put("்ஸ",1010); put("்ல",6654); put("்ற",20507); put("்ள",9314); put("்ம",4103); put("்ர",1658); put("்ய",1630); put("சு ",1200); put("ூன",663); put("ூத",353); put("ூர",3051); put("ூற",1305); put("ூல",1999); put("ூழ",431); put("ுந",4175); put("ுண",1116); put("ுத",14095); put("ுய",369); put("ுர",3253); put("ும",39489); put("ுன",1831); put("ுப",5592); put("ுவ",9858); put("ூக",634); put("ுழ",1268); put("ுள",8293); put("ுல",1485); put("ுற",6692); put("ூட",1699); put("ைவ",1932); put("ைந",3816); put("ைப",6286); put("ைய",15390); put("ைம",945); put("ேல",1655); put("ேற",2141); put("ேர",3972); put("ேய",740); put("ேவ",930); put("ைக",9533); put("ேள",1091); put("ேன",443); put("ேம",327); put("ைத",2725); put("ைச",1726); put("ெள",2310); put("ெல",1418); put("ேக",639); put("ெய",4586); put("ெற",2754); put("ெர",3220); put("ெப",689); put("ென",2012); put("ேண",375); put("ேத",757); put("ேட",601); put("சி ",2531); put("ேச",2248); put("ெக",289); put("ெண",621); put("ெட",1667); put("சை ",644); put("ச் ",3259); put("ati",457); put("ஒளி",281); put("ஒலி",275); put("ஒரு",7842); put("ஒன்",2133); put("கே ",463); put("கை ",1667); put("கா ",505); put("ச ",506); put("க ",8647); put("கு ",5427); put("கி ",1073); put("கச்",348); put("ா ",4799); put("ி ",16257); put("கங்",1149); put("ீ ",453); put("ு ",58822); put("கக்",1119); put("ே ",3658); put("ை ",18418); put("ோ ",1470); put("் ",167861); put("கன்",508); put("கப்",5197); put("கணி",938); put("கண்",880); put("கத்",2578); put("கதை",393); put("கணக",371); put("கடல",480); put("கட்",1973); put("ட ",4634); put("ண ",792); put("த ",6809); put("ஓர்",624); put("ன ",8248); put("ப ",465); put("க் ",7275); put("ர ",1232); put("ய ",9777); put("ம ",541); put("ழ ",296); put("ள ",4773); put("ல ",2350); put("ற ",3775); put("வ ",559); put("ஜன்",468); put("ion",604); put("டி ",2152); put("டா ",281); put("டு ",6809); put("ஜூல",309); put("டை ",967); put("ட் ",1325); put("சங்",473); put("he ",350); put("சத்",482); put("சட்",614); put("சமய",437); put("ங்க",15531); put("சம்",940); put("சமூ",398); put("சன்",386); put("சப்",396); put("சந்",419); put("சர்",489); put("சிவ",528); put("சில",849); put("சிற",1550); put("சிர",415); put("சிய",2735); put("சிப",459); put("சின",560); put("சித",585); put("சிங",311); put("சிக",977); put("சால",592); put("சார",993); put("சாத",575); put(" of",373); put("சென",474); put("சேவ",338); put("சைக",291); put("சேர",1297); put("செல",774); put("செய",2741); put("சும",401); put("சுற",312); put("சுர",362); put("சுவ",666); put("சீன",355); put("ing",312); put("சுக",389); put("சுத",324); put("சூழ",384); put("ச்ச",3340); put("சைய",843); put("சொல",606); put("சொற",288); put("டக ",523); put(" th",509); put("ட்ப",853); put("ட்ட",19814); put("ட்ச",2725); put("ட்க",1235); put("டைய",2172); put("டைப",576); put("டைக",531); put("ணி ",660); put("er ",398); put("es ",343); put("ண் ",586); put("து ",27911); put("தை ",1771); put("தே ",341); put("தி ",2552); put("தா ",680); put("டங்",1549); put("டக்",1238); put("ஞர்",315); put("ஞ்ச",1519); put("டமா",725); put("டமை",297); put("டம்",2072); put("டர்",1679); put("டன்",1240); put("டப்",1121); put("டத்",4115); put("டது",1165); put("டிய",2991); put("டிப",984); put("டின",1240); put("டித",607); put("டிவ",1222); put("டில",1216); put("டிர",537); put("டாண",290); put("டிட",382); put("டிச",401); put("டிக",1256); put("டாவ",366); put("டார",303); put("டுப",1408); put("டும",4650); put("டுத",2954); put("டுவ",1115); put("டுள",785); put("டுக",5293); put("டாக",695); put("டல்",1207); put("தாக",1315); put("தான",1137); put("தாள",370); put("தால",691); put("தாவ",511); put("திக",2302); put("திச",403); put("தாய",342); put("தார",1089); put("தின",3651); put("திப",796); put("திட",432); put("திவ",299); put("திம",291); put("தில",7958); put("திற",783); put("திர",5993); put("திய",6938); put("துக",2030); put("தீவ",583); put("துண",389); put("துட",443); put("துப",404); put("துள",2935); put("துற",954); put("துர",579); put("தும",1383); put("துவ",2062); put("தூர",370); put("தேச",1067); put("தெற",289); put("தென",697); put("தைக",641); put("தேவ",512); put("தைச",349); put("தேர",391); put("தைய",745); put("தொட",1925); put("தொக",1037); put("தொழ",704); put("தொல",527); put("தப்",1587); put("ண்ம",630); put("ண்ப",578); put("தமி",4632); put("தமா",339); put("ண்க",445); put("ண்ண",1196); put("ண்ட",9721); put("தம்",1071); put("தயா",275); put("தற்",1515); put("தலா",427); put("தலி",372); put("தல்",1648); put("தலை",1494); put("தர்",937); put("தவர",662); put("தவி",419); put("த்த",29791); put("ணங்",275); put("ணத்",603); put("த் ",4416); put("ணக்",539); put("ணுக",317); put("ணிக",735); put("ணிய",592); put("ணின",373); put("ணித",474); put("ணைய",630); put("தந்",298); put("தனி",760); put("தன்",2053); put("தனை",537); put("ணைக",298); put("தது",557); put("தத்",779); put("ணம்",660); put("ணப்",571); put("தங்",477); put("தகவ",361); put("தக்",543); put("ணர்",292); put("ந்ந",363); put("ந்த",19873); put("ng ",303); put("னம்",921); put("னர்",1811); put("பகு",1877); put("னது",1015); put("னத்",650); put("நேர",433); put("நெட",597); put("னப்",1023); put("நோக",445); put("நிக",520); put("நாள",908); put("நாய",319); put("நான",310); put("நாத",286); put("நாட",4702); put("நிய",299); put("நிர",619); put("நிற",1236); put("நில",3876); put("நீர",548); put("நீத",282); put("நுட",372); put("நூற",484); put("நூல",812); put("னக்",283); put("னங்",574); put("பற்",788); put("பலர",285); put("பர்",1261); put("பரி",581); put("பரப",390); put("பயன",1636); put("பம்",365); put("of ",362); put("பவர",561); put("பல்",1018); put("பன்",334); put("னைத",388); put("பந்",594); put("னைய",458); put("னைவ",278); put("னைக",358); put("ன்ம",1125); put("ன்ற",10571); put("ன்ப",7799); put("ன்ன",4301); put("பமா",350); put("ன்ட",278); put("ன்க",958); put("ன்ச",382); put("னும",1622); put("னார",414); put("படம",801); put("னிக",390); put("னால",860); put("படத",483); put("படை",1050); put("னின",559); put("பட்",5520); put("னிய",1758); put("னில",287); put("படி",920); put("படு",7705); put("னித",927); put("பத்",1191); put("பது",4499); put("பதா",323); put("பதி",845); put("பண்",714); put("பதற",308); put("பணி",371); put("பங்",436); put("பக்",415); put("னவர",288); put("on ",583); put("பல ",913); put("ன் ",22050); put("னை ",1086); put("பட ",307); put("னா ",289); put("னி ",918); put("ப் ",6813); put("பை ",319); put("நடி",497); put("பு ",2795); put("நடை",406); put("பி ",577); put("நகர",2167); put("மணி",297); put("ரே ",289); put("மது",349); put("மதி",359); put("மத்",609); put("ரு ",7941); put("மட்",449); put("ர் ",16957); put("ரை ",1204); put("றன ",856); put("மன்",1232); put("மனி",790); put("மல்",385); put("மலை",666); put("யக்",1396); put("மம்",421); put("மரப",361); put("மரு",359); put("லக ",292); put("மற்",2141); put("றி ",716); put("மாந",2194); put("மான",2448); put("மாத",610); put("மாக",4202); put("மிய",352); put("மின",800); put("று ",3977); put("மாவ",2559); put("மிக",1315); put("மாற",977); put("மார",743); put("யங்",868); put("யா ",1169); put("ய் ",704); put("யை ",1008); put("யே ",849); put("மகா",275); put("ரா ",278); put("ரி ",1486); put("மங்",313); put("மக்",1291); put("மி ",296); put("மே ",505); put("மை ",1120); put("ம் ",53178); put("பின",1559); put("பிய",742); put("பிர",3751); put("பிற",1054); put("பில",819); put("பிக",486); put("பிட",1127); put("பாத",646); put("பான",683); put("பாய",372); put("பால",940); put("பாள",428); put("பார",981); put("பாக",1005); put("பாட",3059); put("பாண",798); put("பூர",411); put("புத",1109); put("புவ",296); put("புல",660); put("புற",357); put("புர",1163); put("பீட",289); put("புக",1683); put("பேர",1352); put("பெண",307); put("பெய",1296); put("பெர",1861); put("பெற",2100); put("பேச",556); put("போட",316); put("பொற",395); put("பொர",2127); put("பொத",938); put("போல",281); put("போர",737); put("போன",1011); put("போத",864); put("ப்ட",297); put("ப்ப",26657); put("ப்ர",488); put("ளகர",469); put("ளக்",350); put("லம்",2464); put("லமா",457); put("லர்",460); put("லப்",639); put("ழ் ",1697); put("ற்க",4226); put("ற்ச",313); put("ற்ப",2340); put("ற்ற",9892); put("றைக",742); put("றைய",1266); put("வே ",437); put("ளத்",348); put("ளது",1904); put("லைக",1350); put("லேய",338); put("வை ",1638); put("லும",2793); put("லுக",305); put("லிர",748); put("லிய",1493); put("லில",989); put("லூர",479); put("லுள",616); put("வி ",735); put("லிக",541); put("லாற",423); put("லாள",499); put("லாம",957); put("லிப",277); put("லின",516); put("வு ",1989); put("லாக",721); put("லான",565); put("லாந",354); put("ளங்",417); put("லகி",465); put("றம்",427); put("ர்ச",956); put("ர்க",5162); put("ர்வ",1496); put("ர்ம",805); put("ர்ப",1555); put("ர்ந",1909); put("ர்த",1839); put("ர்ட",360); put("றப்",1150); put("ள் ",12275); put("ரைய",957); put("றந்",718); put("ரைப",1450); put("றனர",342); put("ளை ",2755); put("ரைக",424); put("றது",3133); put("றத்",625); put("லத்",2727); put("லது",2796); put("றுவ",1225); put("றும",3125); put("றுப",986); put("றுத",532); put("றுக",1202); put("றில",535); put("றிவ",770); put("றிய",1917); put("றின",604); put("றிப",1027); put("ழு ",279); put("றித",312); put("றார",526); put("றிக",1316); put("றாண",394); put("றாக",1080); put("ழி ",982); put("லங்",2176); put("லக்",1207); put("றழை",438); put("ரபு",329); put("ரப்",990); put("ல் ",34411); put("ய்க",394); put("ய்த",601); put("ய்ய",1010); put("ய்வ",739); put("ரம்",2579); put("ரமா",606); put("ரர்",568); put("ரலா",483); put("யுள",362); put("ரண்",815); put("ரதே",555); put("ரத்",1609); put("ரது",278); put("ளன ",701); put("லை ",2437); put("ரன்",291); put("ளி ",635); put("ராவ",406); put("ரிக",2239); put("ரால",435); put("ராய",388); put("ராம",869); put("ரிச",541); put("ரித",580); put("ரிம",685); put("ரின",1028); put("ரிப",456); put("ராக",2778); put("ராச",370); put("ராஜ",438); put("ராட",1211); put("ரான",615); put("ருங",473); put("ருட",752); put("ருக",4077); put("ருப",877); put("ரும",2991); put("ருத",1851); put("ருந",3294); put("ரிய",3104); put("ரில",735); put("ரிவ",1163); put("ருவ",2848); put("ருள",1674); put("ரூர",620); put("umb",290); put("ரல்",362); put("றங்",282); put("மொழ",2149); put("யப்",1295); put("மைந",2631); put("மைய",1873); put("மைப",1460); put("யன்",2673); put("யமை",293); put("யம்",1435); put("ம்ச",279); put("ம்ம",840); put("ம்ப",4940); put("யமா",620); put("மூல",729); put("மூன",356); put("முழ",336); put("மூக",412); put("மீட",317); put("மிழ",4631); put("முற",1812); put("மும",549); put("முன",1115); put("முத",1979); put("முட",981); put("முக",1304); put("மென",349); put("மெர",642); put("றை ",1441); put("மேல",805); put("மேற",920); put("மைக",943); put("மேள",882); put("யத்",1278); put("யது",423); put("லி ",729); put("லா ",378); put("ரங்",785); put("ரசி",802); put("ரசு",618); put("யும",2862); put("யிர",1042); put("யில",6388); put("யார",713); put("யாவ",2647); put("யாள",533); put("யாழ",607); put("யிட",437); put("யின",2554); put("யிய",701); put("யாக",2905); put("யாட",446); put("யான",1415); put("tio",513); put("thu",314); put("யல்",3022); put("யலா",554); put("யலி",566); put("யற்",1115); put("யர்",1747); put("ter",301); put("the",291); put("யவர",291); put("யவற",284); put("வும",1702); put("வாக",2334); put("வாத",306); put("வாச",280); put("விக",832); put("வாழ",922); put("வால",316); put("வான",889); put("வாய",566); put("வார",1236); put("வித",708); put("விண",306); put("வின",2946); put("விச",326); put("விட",1092); put("வில",3171); put("விள",1040); put("விய",1955); put("விர",904); put("விற",467); put("வுக",1344); put("வீர",321); put("ஸ் ",1708); put("வ்வ",1164); put("வேற",846); put("வேத",466); put("வெள",2232); put("வைய",661); put("வைத",379); put("வைக",768); put("வேல",442); put("வற்",1078); put("வரி",937); put("வரு",1641); put("வரா",523); put("வரை",1143); put("வர்",4658); put("வலை",345); put("வல்",686); put("வளர",473); put("வழங",567); put("ழ்ந",1868); put("ழ்த",442); put("ழ்வ",520); put("ழ்ப",759); put("ழ்க",412); put("வரத",404); put("வரல",407); put("வம்",690); put("வழி",728); put("வடக",309); put("வடி",817); put("ழிப",303); put("ழிக",564); put("ழுவ",343); put("ழும",521); put("வட்",2653); put("ழிய",1078); put("ழில",887); put("ழுத",1586); put("வதற",541); put("வதா",350); put("வது",3201); put("வத்",327); put("வப்",301); put("ழைக",1109); put("வந்",1239); put("வனம",324); put("ழைய",304); put("வன்",676); put("ள்ள",9236); put("ள்க",555); put("ழர்",543); put("ழமை",586); put("வகை",1129); put("வங்",465); put("ழங்",729); put("ளாக",1168); put("ளிப",395); put("ளின",2302); put("ளால",742); put("ளிக",491); put("ளில",4426); put("ளிய",1106); put("ளிவ",966); put("ளுட",327); put("ளுக",1636); put("ளும",1077); put("ளுள",663); put("ளைக",897); put("ளைப",388); put("ளைய",1472); put("லைவ",579); put("லைய",1591); put("லைம",331); put("ளனர",279); put("லைப",623); put("லைந",485); put("லைத",348); put("ளப்",366); put("ல்ல",5939); put("ல்வ",1233); put("ல்ப",618); put("ல்ந",316); put("ல்க",1857); put("ளம்",661); put("ளமா",505); put("ளர்",1471); put("ழகத",295); put("ளவை",282); put("ழக்",933); put("ளவு",424); put("ளவி",419); put(" நட",1718); put(" நக",1501); put(" நா",4504); put(" நி",4279); put(" நெ",933); put(" நே",568); put(" நூ",1176); put(" நீ",1214); put(" நு",519); put(" நவ",316); put(" பட",1904); put(" பண",1105); put(" பத",1073); put(" பன",342); put(" நோ",691); put(" பக",1834); put(" பங",296); put(" பு",2928); put(" பா",4041); put(" பி",5649); put(" பூ",498); put(" பெ",4588); put(" பே",1964); put(" பற",718); put(" பர",1247); put(" பய",1942); put(" பழ",608); put(" பல",2289); put(" பொ",3056); put(" போ",2704); put(" மன",1180); put(" மட",504); put(" மண",418); put(" மத",890); put("ிக ",435); put(" மக",1685); put(" மை",493); put(" மே",3012); put(" மெ",772); put(" மொ",2003); put(" மு",6572); put(" மீ",747); put(" மி",1990); put(" மா",7055); put(" மூ",1353); put(" மர",989); put(" மற",2304); put(" மல",556); put("ால ",279); put(" டி",434); put("ார ",281); put(" தட",289); put(" தக",507); put(" தர",734); put(" தற",353); put(" தல",1342); put(" தம",4737); put(" தய",281); put(" தன",1258); put(" து",1451); put(" தீ",745); put(" தூ",310); put(" தி",4210); put(" தா",1353); put(" தெ",1340); put(" தே",1470); put(" தொ",4079); put(" தோ",559); put("�",1175); put(" ஸ்",417); put("ான ",5124); put("ாண ",290); put("ாத ",411); put(" ரா",553); put(" யா",744); put(" வட",1713); put(" வண",356); put(" வத",741); put(" வக",1085); put(" வச",354); put(" வர",2716); put(" வல",690); put(" வழ",1368); put(" வள",796); put(" வந",384); put(" வி",5451); put(" வீ",639); put(" வா",2177); put(" வை",533); put(" வே",1627); put(" வெ",2854); put(" உண",846); put(" உத",491); put(" உட",908); put(" ஈழ",284); put(" உள",3279); put(" உல",1058); put(" உற",820); put(" உர",1675); put(" உய",988); put(" இண",833); put(" இத",5634); put(" இட",1528); put(" இங",400); put(" இச",1164); put(" ஆவ",1943); put(" இக",391); put(" ஆய",570); put(" ஆம",1553); put(" ஆற",781); put(" ஆர",1069); put(" ஆப",332); put(" ஆன",365); put(" இவ",2571); put(" இல",3087); put(" இற",478); put(" இர",6995); put(" இய",2150); put(" இம",448); put(" இப",504); put(" இன",1051); put(" இந",4772); put(" எட",530); put(" எத",528); put(" எண",593); put(" என",11142); put(" ஊர",477); put("ாக ",5165); put(" அக",780); put(" அச",377); put(" அட",1678); put(" அத",1971); put(" அண",901); put(" அந",301); put(" அன",909); put(" அப",485); put(" அம",5119); put(" அர",2421); put(" அற",1466); put(" அல",3607); put(" அள",796); put(" ஆக",6168); put(" அழ",1038); put(" அவ",1449); put(" ஆங",1422); put(" ஆச",512); put(" ஆட",602); put(" ஆண",2832); put(" சர",400); put(" சம",1684); put(" சந",326); put(" சட",638); put(" சங",283); put(" சக",625); put(" ஜூ",466); put(" ஜெ",287); put(" ஜன",633); put(" சோ",491); put(" சொ",885); put(" சா",1798); put(" சி",3884); put(" சீ",724); put(" சு",1865); put(" சூ",738); put(" செ",4613); put(" சே",1783); put(" ஒர",8153); put(" ஒன",2134); put(" ஏற",1035); put(" ஐக",383); put(" எழ",1219); put(" எல",516); put(" கவ",401); put(" கு",5595); put(" கூ",1517); put(" கா",3988); put(" கி",3235); put(" கீ",461); put(" கொ",3490); put(" கோ",2006); put(" கை",284); put(" கே",530); put(" கண",2002); put(" கத",414); put(" கட",2692); put(" கன",550); put(" கழ",306); put(" கள",362); put(" கல",1562); put(" கர",2268); put(" ஒல",300); put(" ஒள",281); put(" ஓர",762); put("ஸ்க",347); put("ஸ்ட",597); put("ஸ்த",763); }};
    private static final int[] n_words_s = {2733895,2995227,2314467};
    private static final String name_s = "ta";

    public Profile_ta() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
