package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_gu extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>(1474) {{ put("ૈદિ",382); put("g",235); put("d",312); put("e",960); put("c",304); put("a",1076); put("n",720); put("o",584); put("l",382); put("m",289); put("h",369); put("i",764); put("u",324); put("t",728); put("s",517); put("r",627); put("ોટ ",345); put("ેસા",764); put("ોલ ",730); put("ોર ",574); put("ોદ ",1827); put("ેત્",227); put("ેતી",2222); put("ેતમ",2186); put("ેતપ",357); put("ેડબ",253); put("ેડા",1366); put("ેડી",300); put("ેગા",229); put("ેગો",375); put("ેઘર",242); put("ૈકી",6300); put("ેશમ",527); put("ેશન",12436); put("ેવી",831); put("ેવા",710); put("ઇડર",265); put("ેરા",387); put("ેરી",718); put("આહવ",288); put("ેલા",24917); put("ેલી",519); put("ેલુ",9935); put("ેલો",381); put("ોઇ ",458); put("ેન્",278); put("ેપુ",457); put("આવે",34862); put("ા",337683); put("િ",47127); put("સ",31472); put("હ",20294); put("શ",32541); put("ષ",5409); put("વ",91695); put("લ",111041); put("ળ",3931); put("ર",102867); put("ય",39143); put("મ",113670); put("ભ",35403); put("બ",10569); put("ફ",1198); put("પ",49237); put("ન",84304); put("ધ",9131); put("દ",38743); put("થ",6321); put("ત",89107); put("ણ",9770); put("ઢ",1233); put("ડ",18443); put("ઠ",3507); put("જ",54268); put("ઝ",1439); put("ટ",6287); put("ઘ",2525); put("ચ",20557); put("છ",25106); put("ક",72592); put("ખ",14557); put("ગ",61691); put("ઓ",8101); put("એ",23599); put("ઉ",5095); put("ઈ",409); put("અ",6168); put("ઇ",1975); put("આ",43598); put("ં",82987); put("૫",1391); put("૪",875); put("૩",2115); put("૨",1146); put("૯",1054); put("૮",946); put("૭",1034); put("૬",461); put("૧",5611); put("૦",1269); put("ૈ",7159); put("ો",34921); put("્",89060); put("ૌ",562); put("ુ",82336); put("ી",42473); put("ૃ",539); put("ૂ",4236); put("ે",108368); put("આણં",435); put("આદિ",1564); put("ેશ ",483); put("અને",1581); put("અન્",344); put("e ",271); put("અમદ",630); put("ેમ ",2812); put("ેર ",1681); put("ેલ ",1022); put(" ૧",4255); put(" ૩",409); put(" ૨",679); put(" ૫",978); put(" ૪",492); put(" ૭",700); put(" ૯",551); put(" ૮",625); put("અગિ",1051); put(" વ",14987); put(" શ",3197); put(" ર",16267); put(" લ",5654); put(" સ",11956); put(" હ",3244); put(" થ",1672); put(" ત",31864); put(" ધ",1718); put(" દ",21808); put(" ડ",1738); put(" ઠ",222); put(" ભ",34182); put(" બ",4095); put(" ય",383); put(" મ",24848); put(" ન",6795); put(" ફ",765); put(" પ",35455); put(" છ",24245); put(" ચ",2656); put(" ઘ",628); put(" ટ",479); put(" ઝ",829); put(" જ",21642); put(" ઓ",682); put(" ગ",30845); put(" ખ",8068); put(" ક",14981); put(" ઉ",4757); put(" એ",23366); put(" આ",43205); put(" ઇ",661); put(" અ",6143); put("આંગ",703); put("્ચિ",11645); put("્ટ્",549); put("ોતર",377); put("ોદર",1858); put("ોનગ",236); put("ોટા",473); put("ોટી",225); put("ોડા",794); put("આઠ ",685); put("ોની",800); put("ોનો",2167); put("ોરી",514); put("ોળી",244); put("ોલી",442); put("ંવત",748); put("ંબા",470); put("ંબુ",281); put("ંમત",254); put("ંઠા",1406); put("ંડવ",256); put("ંદુ",455); put("્ધ ",712); put("ંદો",312); put("ંધી",504); put("ંતર",406); put("ંચા",1418); put("ંચમ",1337); put("ંગા",221); put("્ર ",966); put("ોકો",3591); put("્ય ",7092); put("ંગણ",713); put("ંખે",303); put("ંગર",288); put("્ષ ",789); put("્વ ",2508); put("એવા",6093); put("્ષન",1137); put("્ષિ",1509); put("્વા",430); put("્વે",772); put("્વન",6820); put("્વર",251); put("્યન",12109); put("્યત",720); put("્યમ",432); put("્યપ",428); put("્યવ",2272); put("્યા",2476); put("્યુ",248); put("્મદ",563); put("્મા",375); put("્લો",1068); put("્લા",13052); put("્રો",432); put("્રે",602); put("્રમ",649); put("્રદ",871); put("્રા",2175); put("્રિ",476); put("્રી",593); put("્રહ",375); put("્દ્",258); put("્થા",288); put("્તા",298); put("્તી",856); put("્તર",2535); put("એક ",15869); put("ઉદે",246); put("ઉપલ",606); put("ઉપર",392); put("ઉત્",2557); put("ઉમર",329); put("િત",853); put("િણ",1494); put("વિજ",359); put("ીં",343); put("િમ",11976); put("િપ",550); put("િન",1570); put("વાય",500); put("િવ",4622); put("વાર",525); put("િશ",322); put("ીક",534); put("વામ",999); put("િલ",14752); put("ીઓ",697); put("િય",2671); put("િર",803); put("વાસ",1799); put("ીજ",386); put("િહ",232); put("વિક",492); put("િસ",578); put("વાલ",357); put("ીત",406); put("ીદ",281); put("ું",22062); put("વાદ",862); put("વાન",404); put("ીય",2619); put("ીમ",860); put("ીન",8731); put("વાડ",2612); put("ીપ",459); put("ુક",18441); put("ીવ",394); put("ુખ",4304); put("ીર",426); put("ીલ",229); put("વાગ",247); put("વાઘ",254); put("ીસ",510); put("ુચ",222); put("ુજ",13015); put("ાં",48849); put("ાઉ",298); put("ાઇ",474); put("ાક",921); put("ાઓ",6449); put("ાઘ",283); put("ાખ",279); put("ાગ",19994); put("ાજ",13842); put("ાચ",245); put("ાટ",1064); put("ાડ",4936); put("િં",1255); put("ાણ",2500); put("ાથ",1359); put("ાત",14028); put("ાદ",2250); put("ાન",14000); put("ાપ",2091); put("ાબ",1765); put("ામ",34603); put("ાય",4603); put("ાર",20818); put("ાલ",24953); put("ાળ",1774); put("વિર",286); put("િક",2870); put("ાવ",3657); put("ાષ",849); put("ાસ",4564); put("ાહ",1263); put("િજ",517); put("વિસ",266); put("હત",7478); put("સી",2165); put("સુ",1962); put("સે",1528); put("સા",8757); put("સિ",770); put("હવ",567); put("સો",764); put("હર",240); put("સ્",3025); put("સૌ",277); put("હુ",529); put("સા ",522); put("હે",3680); put("હા",2824); put("હિ",2043); put("હી",349); put("હો",1278); put("હ્",385); put("શ્",12458); put("ષન",1142); put("સગ",988); put("સર ",276); put("શહ",485); put("શિ",374); put("શા",1696); put("શુ",2253); put("શી",262); put("સં",2001); put("ષ્",864); put("સમ",828); put("સન",417); put("સવ",569); put("સર",997); put("ષા",458); put("સદ",328); put("સત",251); put("સણ",439); put("ષિ",1579); put("વદ",549); put("વન",7118); put("વર",2659); put("વલ",1055); put("શક",498); put("વગ",256); put("વસા",2722); put("વડ",3280); put("વત",1294); put("વણ",314); put("વે",36512); put("શન",12531); put("વૈ",520); put("શમ",627); put("વ્",2839); put("વસ",7405); put("વી",2081); put("વિ",2302); put("વા",17902); put("લો",6663); put("લ્",14395); put("લે",641); put("લા",40018); put("લિ",942); put("લી",2736); put("લુ",28591); put("લસ",736); put("લવ",315); put("વસ્",826); put("વસે",1125); put("ળી",539); put("વં",274); put("ળા",1514); put("રો",1975); put("ર્",7275); put("રુ",979); put("રી",7304); put("રૂ",908); put("રે",1966); put("રસ",718); put("વાં",660); put("રહ",1839); put("રા",36128); put("રિ",1193); put("રવ",1135); put("લબ",632); put("લપ",735); put("લય",580); put("લન",2427); put("લક",304); put("લગ",215); put("રક",1797); put("રગ",229); put("રખ",218); put("યવ",2310); put("રજ",562); put("યા",7096); put("રડ",414); put("યુ",510); put("રણ",534); put("રત",14232); put("રથ",239); put("રદ",1032); put("શમા",566); put("યે",847); put("રન",646); put("રપ",682); put("યો",569); put("રબ",221); put("રમ",2425); put("મર",703); put("મમ",2823); put("મલ",319); put("મહ",10705); put("રં",397); put("મી",561); put("યડ",242); put("મુ",6197); put("મા",44661); put("મિ",1415); put("યત",1490); put("યપ",480); put("યન",12830); put("મે",837); put("યમ",548); put("મ્",803); put("મો",2623); put("બ્",1122); put("ભર",899); put("મજ",2296); put("મગ",222); put("મખ",281); put("મણ",336); put("મત",581); put("મથ",816); put("ભા",32622); put("ભિ",388); put("મપ",589); put("ભો",320); put("મદ",1417); put("મધ",3415); put("મન",2890); put("બર",1834); put("બહ",293); put("મં",287); put("બી",424); put("બુ",465); put("બા",2768); put("બિ",244); put("બો",581); put("બે",417); put("પો",705); put("પ્",4053); put("બન",257); put("પલ",826); put("પહ",227); put("પશ",13852); put("પર",1594); put("પૂ",2675); put("પૈ",6312); put("પે",306); put("પુ",5227); put("પી",742); put("પિ",245); put("પા",6287); put("ન્",1623); put("નો",5861); put("પણ",494); put("પત",282); put("પટ",291); put("પડ",321); put("પછ",431); put("નવ",1459); put("નર",658); put("ધ્",3586); put("ધો",283); put("નપ",579); put("નન",237); put("ને",4269); put("નુ",10812); put("પં",2789); put("ની",3990); put("નિ",691); put("ના",45180); put("નસ",606); put("ધા",1073); put("ધુ",315); put("ધી",641); put("દે",14545); put("ધન",837); put("દ્",1191); put("દો",459); put("ધર",916); put("સી ",1244); put("નગ",2570); put("દશ",215); put("દસ",731); put("દહ",218); put("દા",3639); put("દિ",5058); put("દી",575); put("દુ",1289); put("દર",3345); put("થવ",580); put("વેલ",34942); put("શના",12337); put("થી",1041); put("થા",882); put("તો",531); put("વૈદ",382); put("તે",6014); put("દક",1517); put("થય",782); put("ત્",12219); put("થમ",1093); put("થક",777); put("તી",4432); put("તુ",553); put("તા",26724); put("તિ",1123); put("તન",712); put("ણે",327); put("તપ",511); put("તર",3967); put("તલ",356); put("તમ",2718); put("ણા",2366); put("ણી",846); put("ણવ",795); put("તઘ",640); put("ડો",2767); put("ડુ",286); put("ડે",1027); put("ણં",571); put("ડી",3535); put("ડિ",410); put("ડા",5615); put("ડવ",598); put("ડર",315); put("ડભ",218); put("ડબ",277); put("ઠા",1831); put("ટ્",673); put("ટે",774); put("વ્ય",2778); put("ટિ",249); put("સે ",1144); put("ટી",761); put("છે",23574); put("જન",365); put("છી",486); put("ઝઘ",245); put("જય",244); put("છો",305); put("જબ",1127); put("જર",11973); put("જે",2020); put("જો",465); put("જિ",13950); put("જા",1399); put("જુ",2555); put("જી",794); put("જ્",13119); put("ઝર",271); put("શુપ",2187); put("ઝા",567); put("સંવ",756); put("ટક",225); put("સંત",320); put("સંખ",325); put("ટા",840); put("ટલ",348); put("ગા",17980); put("ગુ",12125); put("ગિ",1160); put("ઘડ",264); put("ગી",427); put("૯ ",627); put("ગ્",891); put("ગો",1143); put("ઘર",948); put("ઘો",548); put("ચર",560); put("ચમ",1383); put("ચા",2321); put("ચિ",12038); put("ચી",259); put("જં",215); put("ચો",437); put("ચ્",251); put("જક",251); put("શહે",470); put("૫ ",1091); put("કર",2446); put("કમ",270); put("કલ",513); put("કપ",478); put("ખં",251); put("કડ",644); put("ખલ",227); put("ક્",3347); put("કો",5466); put("કે",1500); put("૭ ",792); put("કુ",6686); put("કૃ",229); put("કા",21625); put("કી",6922); put("કિ",350); put("કહ",564); put("કવ",583); put("ગવ",1115); put("ગલ",272); put("ગર",2876); put("ગમ",18397); put("ખ્",4351); put("૮ ",673); put("ખે",6309); put("ગન",575); put("ગણ",1117); put("ગઢ",779); put("ખા",2071); put("૧ ",1168); put("શાળ",1055); put("શાસ",252); put("એવ",6158); put("૨ ",320); put("૩ ",1541); put("૪ ",593); put("ઓન",283); put("એક",16184); put("૦ ",810); put("ઉદ",317); put("ઉત",2595); put("ઉપ",1216); put("સગવ",904); put("ઉમ",378); put("આં",1102); put("અગ",1187); put("અં",436); put("ઇડ",287); put("ષના",751); put("આહ",296); put("ષનો",362); put("આવ",35199); put("આદ",1695); put("આઠ",804); put("આણ",440); put("અમ",826); put("અર",256); put("અન",2071); put("ંવ",912); put("ંસ",486); put("ંત",1429); put("ંથ",310); put("ંદ",2195); put("ંધ",939); put("ંબ",1038); put("ંભ",281); put("ંમ",287); put("ંક",540); put("શ્ચ",11655); put("ંગ",2855); put("ંખ",377); put("ંચ",4016); put("ંજ",464); put("ંટ",564); put("ંડ",982); put("ંઠ",1433); put("હે ",1152); put("શ્ર",320); put("શ્વ",348); put("૧૩",1467); put("૧૧",1091); put("૧૯",283); put("૧૦",694); put("વડો",2345); put("ોટ",1277); put("ોડ",1517); put("ોજ",373); put("વલી",267); put("ોન",3584); put("ોધ",322); put("ોત",616); put("ોદ",3809); put("ોગ",284); put("ોક",3826); put("ોઇ",523); put("્ટ",1147); put("્ત",4385); put("્ણ",325); put("્દ",602); put("્થ",651); put("્ધ",1001); put("્પ",336); put("્બ",262); put("વર્",2136); put("્ક",609); put("્ગ",267); put("્ચ",11827); put("ોમ",362); put("ોલ",1612); put("ોય",246); put("ોર",2045); put("ોવ",257); put("વલસ",582); put("ોળ",645); put("્સ",302); put("્ષ",3855); put("્વ",11263); put("્લ",14321); put("્ર",8621); put("્ય",26212); put("્મ",1641); put("ૂર",2771); put("ુદ",699); put("ુધ",815); put("ુન",510); put("ુણ",524); put("ુત",213); put("ુમ",369); put("ુર",8763); put("ુપ",2377); put("ુવ",804); put("ુસ",354); put("ુલ",6351); put("ૂચ",717); put("વનો",376); put("વનુ",6376); put("ૃત",300); put("ેક",249); put("ેત",5179); put("ેડ",2071); put("ેટ",618); put("ેઠ",219); put("ેજ",326); put("ેગ",653); put("ેઘ",271); put("ષા ",222); put("વતા",228); put("ેર",3345); put("ેલ",37195); put("ૈક",6315); put("ેશ",13804); put("ેવ",2024); put("ેન",1094); put("ેપ",540); put("ેમ",3602); put("ૈદ",389); put("ેસ",990); put("હિં",776); put("હાલ",1485); put("હાર",571); put("હિન",919); put("ઇ ",1018); put("આ ",2702); put("ાં ",41350); put("ઓ ",7041); put("હેર",525); put("હેલ",239); put("હેવ",536); put("હેસ",730); put("એ ",663); put("ાઇ ",270); put("હોદ",867); put("હ્મ",326); put("ાઓ ",6349); put("ં ",62940); put("ાગ ",214); put("ાડ ",990); put("ાદ ",1109); put("ાણ ",231); put("ાત ",12086); put("ાન ",979); put("ામ ",12051); put("ાલ ",1653); put("ાર ",2510); put("ાય ",3046); put("ાવ ",357); put("િક ",1785); put("ાસ ",1162); put("ષિણ",1462); put("ે ",34827); put("ો ",11870); put("સણા",264); put("ષ ",917); put("સ ",4627); put("સમો",292); put("વ ",3614); put("શ ",598); put("સરા",281); put("ષ્ટ",602); put("િ ",698); put("ુ ",1292); put("ી ",24520); put("ા ",103799); put("સવા",466); put("સુર",1060); put("દ ",4991); put("થ ",242); put("સીઓ",544); put("ન ",4557); put("સુદ",463); put("ધ ",850); put("સાડ",665); put("સાત",801); put("સાણ",973); put("સાગ",213); put("પ ",563); put("સાય",2235); put("સામ",236); put("સાર",662); put("સાવ",281); put("સાબ",1406); put("બ ",1292); put("મ ",27791); put("સોન",293); put("ર ",16908); put("ય ",11483); put("લ ",10111); put("હતા",268); put("હત્",6808); put("ળ ",723); put("ક ",19636); put("ગ ",1433); put("સ્વ",268); put("સ્થ",430); put("ચ ",2010); put("સ્ટ",235); put("સ્ત",1316); put("સ્ક",359); put("જ ",4325); put("ટ ",1263); put("ડ ",2185); put("ઠ ",958); put("ઢ ",645); put("હવે",238); put("ણ ",3405); put("હવા",327); put("ત ",27700); put("ૂચ ",710); put("િત્",251); put("ાસા",294); put("ાસિ",270); put("ાસી",1732); put("ાહો",869); put("ાષા",325); put("ાસણ",337); put("ુલ ",6018); put("ાસર",237); put("ાષ્",514); put("ાલન",2232); put("ાલપ",364); put("ાલય",562); put("ંગ ",904); put("ારે",564); put("ાર્",428); put("ારો",350); put("ારી",908); put("ારા",1301); put("ારત",13028); put("ારમ",342); put("ારડ",261); put("ાયત",689); put("ાયડ",229); put("ામા",16128); put("ુર ",3220); put("ાવી",500); put("ાવા",1445); put("ાવલ",274); put("િકે",222); put("િક્",471); put("ંચ ",1075); put("ાવત",219); put("ાળા",1219); put("ાલો",667); put("ાલુ",18139); put("ાલી",427); put("ાલિ",223); put("ાલા",242); put("ાનો",1081); put("ંટ ",317); put("ાનપ",429); put("ાના",6337); put("ાનુ",3493); put("ાની",787); put("ંજ ",235); put("ાદર",601); put("ામપ",347); put("ંત ",433); put("ામન",2336); put("ામમ",2770); put("ાબર",1409); put("ાપ્",387); put("ુદ ",457); put("ાપી",523); put("ાપુ",503); put("ાપા",321); put("ંદ ",612); put("ીદા",229); put("ીનગ",468); put("ીના",6429); put("ીને",1070); put("ીની",270); put("ીનો",264); put("િસ્",315); put("િલ્",13910); put("િલો",366); put("િવસ",2730); put("િવા",1650); put("િનો",226); put("િના",989); put("િયા",2403); put("ાંટ",436); put("ાંઠ",1422); put("ાંડ",461); put("ાંગ",1094); put("ાંચ",1295); put("ાંત",590); put("ાંધ",547); put("ાંદ",419); put("ાંસ",263); put("ીઓ ",502); put("િમ ",11653); put("િપ ",367); put("િત ",360); put("િણ ",1447); put("ાણા",1231); put("ાણી",404); put("ાતી",550); put("ાત્",264); put("ાથમ",992); put("ાતે",354); put("ાટી",295); put("ાટે",280); put("િંમ",251); put("િંદ",527); put("ાડી",1596); put("ાડા",2060); put("ાજક",237); put("ાજી",257); put("ાજ્",12491); put("ીય ",442); put("ાકી",371); put("ાગમ",18270); put("ાગન",475); put("ાઉદ",238); put("ું ",21442); put("ૂર્",2560); put("ેટ ",236); put("ુણા",437); put("ુજબ",1107); put("ુજર",11840); put("ુપા",2208); put("ુધન",587); put("ીયન",389); put("ીમા",379); put("ીયા",1731); put("ીમખ",262); put("ીસમ",292); put("ુકા",17641); put("ુકો",529); put("ુખ્",4233); put("ુરી",2300); put("ુરુ",440); put("ુરા",1358); put("ુરત",829); put("ુવા",696); put("તઘર",640); put("ણવા",740); put("દસ ",512); put("ણાવ",406); put("દા ",938); put("તપુ",465); put("તનગ",252); put("દી ",294); put("તના",216); put("દુ ",479); put("તમજ",2184); put("તમા",321); put("તરી",269); put("તરા",350); put("તો ",423); put("થા ",316); put("થી ",996); put("નવ ",475); put("થવા",574); put("ના ",41544); put("ને ",3899); put("ની ",3744); put("નો ",5537); put("દરા",2352); put("દરમ",423); put("તું",277); put("તાલ",18057); put("તાર",306); put("તાપ",566); put("તાન",302); put("ધા ",271); put("તેમ",3056); put("તેર",1418); put("તેન",315); put("દક્",1484); put("ત્ત",2727); put("થમિ",987); put("ત્વ",7552); put("ત્ય",281); put("ત્ર",1452); put("થયે",642); put("નપુ",541); put("પી ",564); put("ધીન",468); put("ધાર",249); put("ધાન",290); put("નવસ",483); put("નસવ",370); put("ધ્ય",3481); put("નર્",560); put("દુધ",605); put("દેપ",250); put("દેશ",13431); put("દેવ",535); put("ધની",595); put("દાવ",797); put("દિક",394); put("દાર",330); put("દાદ",262); put("દિવ",4303); put("દાહ",863); put("નગર",2214); put("નગઢ",247); put("પર ",286); put("પણ ",420); put("દોદ",293); put("દ્વ",331); put("દ્ર",524); put("ધરા",484); put("બા ",381); put("પટે",233); put("પાવ",384); put("પાર",273); put("પાલ",2355); put("પાટ",403); put("પાડ",735); put("પાં",1274); put("પશ્",11653); put("પશુ",2197); put("પલબ",596); put("પરા",655); put("પંચ",2575); put("નું",10559); put("નાં",923); put("નાર",240); put("નામ",306); put("નાન",1138); put("પછી",428); put("ન્ય",559); put("ન્દ",395); put("બહુ",235); put("બાક",373); put("બાર",800); put("બાય",217); put("રજ ",269); put("મા ",715); put("મી ",253); put("યડ ",217); put("યન ",455); put("બરક",1386); put("મો ",1343); put("પૂર",2616); put("પુર",4959); put("પૈક",6303); put(" આ ",2656); put("પોર",340); put(" એ ",485); put("પ્ર",3459); put("પ્ય",389); put("માં",41157); put("માટ",294); put("માન",402); put("માણ",276); put("માત",359); put("માલ",325); put("માર",263); put("મિક",1063); put("મહત",6802); put("મહા",1848); put("મહિ",850); put("મહુ",233); put("મહે",917); put("યત્",701); put("મેઘ",271); put("મુખ",4261); put("મુજ",1125); put("મુવ",353); put("યતઘ",640); put("મપુ",552); put("રે ",767); put("મમા",2808); put("મધ્",3365); put("મદા",1324); put("રી ",4562); put("મના",2419); put("રો ",232); put("મજુ",2185); put("મખે",264); put("રા ",5544); put("મતન",247); put("મથક",765); put("ભિલ",318); put("ભાર",12956); put("ભાગ",18607); put("ભાષ",335); put("બોર",287); put("રત ",13401); put("યા ",2563); put("રમ ",485); put("યો ",254); put("ભરૂ",710); put("બ્ર",421); put("બ્ધ",597); put("ળા ",1138); put("રેગ",384); put("ળી ",385); put("રોત",365); put("રાં",597); put("રાય",238); put("રામ",591); put("રાવ",421); put("રિક",325); put("રાષ",510); put("રાડ",230); put("રાણ",287); put("રાત",11870); put("રાથ",991); put("રાપ",541); put("રાજ",13365); put("રીય",783); put("રીન",986); put("રું",396); put("રીક",260); put("રિય",414); put("રૂચ",710); put("રવા",911); put("રહવ",219); put("રહે",1153); put("રહ્",327); put("રપુ",361); put("રમ્",382); put("રમા",804); put("લો ",1417); put("લા ",25318); put("રના",235); put("યેલ",764); put("લી ",1812); put("રદે",816); put("રડી",227); put("યાલ",588); put("યાર",1934); put("યાન",576); put("યાપ",305); put("રકા",1582); put("લય ",553); put("યવસ",2216); put("યપૂ",410); put("મોડ",217); put("મોટ",454); put("યનો",326); put("યના",11717); put("મ્ય",415); put("યમા",407); put("લન ",2219); put("મ્બ",232); put("લ્લ",14131); put("વે ",1140); put("લોલ",465); put("લોડ",396); put("લોદ",449); put("લોક",3642); put("વા ",7780); put("વી ",1602); put("લુક",18002); put("લીમ",321); put("લુણ",389); put("લિય",312); put("લું",9913); put("વસ ",2535); put("લાન",6932); put("લિપ",369); put("લાસ",286); put("લાવ",223); put("લાલ",307); put("લામ",5764); put("લસા",677); put("શક ",371); put("વર ",236); put("લબ્",597); put("વદ ",505); put("લપુ",412); put("વત ",759); put("વડ ",417); put("ર્ષ",1963); put("ર્વ",2626); put("ર્ય",411); put("ર્મ",900); put("કી ",503); put("કા ",605); put("કે ",834); put("કો ",1354); put(" ૧૦",680); put("૧૦ ",535); put("૧૧ ",1036); put("૧૩ ",1412); put("ગઢ ",538); put(" ૧૩",1456); put(" ૧૧",1079); put(" ૧૯",274); put("ગર ",1959); put("કડી",283); put("કડા",244); put("કરવ",314); put("કરી",1162); put("કવા",445); put(" હો",303); put(" હિ",944); put(" હા",540); put(" સો",475); put(" સૌ",273); put(" સ્",714); put(" સિ",322); put(" સા",3562); put(" સુ",1717); put(" હત",654); put(" સમ",395); put(" સર",370); put(" સત",226); put("કાલ",238); put("કામ",9196); put("કાર",676); put("કીન",6304); put("કુલ",6004); put(" લુ",420); put(" લી",386); put(" લિ",414); put(" લા",253); put("કહે",527); put(" લો",3728); put("કાં",1539); put(" રહ",1203); put(" રા",13805); put("કાન",2517); put("કાઓ",6055); put(" સં",1919); put(" શા",1268); put(" શિ",264); put(" શહ",475); put(" સગ",922); put("ઘર ",662); put(" શ્",290); put(" વા",1551); put(" વિ",1924); put(" વસ",1926); put(" વ્",2581); put(" વૈ",515); put(" વે",236); put(" વડ",2142); put(" વર",2148); put(" શક",474); put(" વલ",624); put(" વદ",498); put(" પછ",431); put(" પટ",261); put(" પણ",391); put(" નો",313); put(" પા",2926); put(" પુ",759); put(" પૂ",2113); put(" પૈ",6312); put(" પર",651); put(" પશ",13847); put(" પહ",226); put(" ધા",386); put(" દ્",305); put(" દે",13156); put(" નગ",894); put(" ધર",567); put(" ના",1491); put(" નિ",408); put(" નસ",380); put(" ને",386); put(" પં",2780); put(" ધો",248); put(" નવ",1299); put(" નર",628); put(" મધ",3389); put(" ભિ",335); put(" ભા",32144); put(" મથ",749); put(" ભર",862); put(" મે",521); put(" મો",1041); put(" મા",2519); put(" મુ",5993); put(" મહ",9472); put(" પ્",3289); put(" પો",348); put(" બો",476); put(" બે",295); put(" મં",217); put(" બી",247); put(" બા",1559); put(" બહ",292); put(" ડા",372); put("કોન",2841); put(" ડે",860); put("કોળ",215); put("કોટ",356); put("ક્ષ",1887); put("ક્ર",890); put(" ત્",349); put(" થય",778); put(" દક",1478); put(" તે",5306); put(" થવ",379); put(" દર",551); put(" દુ",722); put(" દિ",2858); put(" દા",1294); put("કેટ",221); put(" દસ",704); put(" તર",348); put(" તિ",233); put(" તા",24717); put(" ૯ ",497); put(" ગો",553); put(" ગ્",552); put(" ગુ",12029); put("ખેડ",1595); put("ખેત",4414); put(" ગા",16841); put("ગના",399); put(" ૮ ",570); put(" ખે",5659); put(" ખા",1675); put(" ગણ",237); put(" ચર",392); put(" ઘો",266); put(" છો",266); put("ગણવ",693); put(" ઝઘ",243); put(" છે",23548); put(" ચો",383); put(" જં",214); put(" ચા",714); put(" ચિ",300); put(" ઝા",412); put(" જ્",480); put(" જુ",259); put(" જા",631); put(" જિ",13843); put(" જો",332); put(" જે",1921); put("ખાસ",931); put(" એવ",6158); put("ખાન",217); put(" એક",16184); put("ખાત",404); put(" ૫ ",907); put(" ૪ ",431); put(" કહ",562); put(" કવ",319); put(" કુ",6308); put(" કા",1279); put(" કો",831); put(" ૭ ",640); put(" કે",929); put(" ક્",383); put(" કડ",504); put(" કપ",373); put(" કલ",240); put(" કર",2121); put(" ઇડ",271); put(" આહ",296); put(" આવ",35196); put(" આદ",1582); put(" ઉત",2589); put(" ઉપ",1212); put(" ઉમ",372); put("ગવડ",906); put("ગરહ",219); put("ગમા",18349); put("ખ્ય",4323); put(" અં",432); put(" અગ",1187); put(" આં",1036); put(" અન",2069); put(" અર",252); put(" અમ",825); put(" આઠ",804); put(" આણ",440); put("ગાં",635); put("ગામ",16798); put("ગિય",1057); put("ગુજ",11824); put("ઘડી",254); put("ગોર",435); put("ગોધ",222); put("ગ્ર",743); put("ઘરજ",242); put("છી ",438); put("ઘોડ",335); put(" જ ",2898); put("છે ",23415); put("જબ ",1105); put("ચરો",362); put("ચાર",560); put("ચાય",582); put("ચિમ",11652); put("ચાં",471); put("ચાગ",369); put("જી ",285); put("જા ",331); put("ચમહ",1210); put("જે ",397); put("જકો",214); put("ઝઘડ",245); put("જિલ",13824); put("જુર",2204); put("છોટ",245); put("જરા",11822); put("ઝાલ",270); put("ઠા ",1548); put("ટી ",375); put("ટા ",336); put("જેવ",714); put("જેત",374); put("જ્ય",12917); put("ટે ",225); put("ડી ",2334); put("ડા ",4375); put("ડર ",279); put("ટેલ",254); put("ટાઉ",239); put("ડો ",637); put("ણી ",405); put("ણા ",1630); put("ટ્ર",578); put("ડેર",603); put("ડેડ",232); put("તી ",3871); put("ડોદ",1844); put("તે ",714); put("ડિય",272); put("ડાસ",222); put("ણંદ",569); put("ડીય",740); put("તિ ",370); put("તા ",7106); put("તર ",2912); put("થક ",760); put("ડાં",355); put("ડબ્",254); put("ણે ",229); }};
    private static final int[] n_words_s = {2118540,2468202,1874859};
    private static final String name_s = "gu";

    public Profile_gu() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
