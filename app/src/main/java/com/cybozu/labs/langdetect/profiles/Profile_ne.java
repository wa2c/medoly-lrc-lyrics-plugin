package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_ne extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>() {{ put("ेश्",122); put("ेष्",121); put("दन ",955); put(" कम",272); put(" कर",171); put(" कल",142); put(" कि",313); put("ेशक",101); put(" का",2467); put(" कृ",130); put(" कु",353); put(" के",400); put(" को",746); put(" क्",668); put("ेवा",114); put("ेवी",117); put(" एक",2232); put(" एम",84); put(" एस",66); put(" एव",82); put("ेही",103); put(" चौ",73); put(" चु",87); put(" ची",65); put(" चि",272); put(" चा",174); put(" छन",436); put("थी ",98); put(" जर",83); put("तको",395); put(" छो",111); put(" जस",287); put(" १ ",94); put("तका",126); put(" छा",110); put(" जन",834); put(" ज्",137); put(" २ ",106); put(" जि",1031); put(" जा",297); put(" जु",184); put(" जी",93); put(" जे",102); put("था ",777); put(" छ।",1176); put(" जो",201); put(" ३ ",81); put(" झा",69); put(" गर",1726); put(" खो",93); put(" खे",113); put(" गण",154); put(" गत",96); put(" खा",152); put(" घर",283); put(" गौ",72); put(" गो",262); put(" ग्",152); put("ैति",183); put(" गु",176); put(" गा",503); put(" । ",1729); put("दछ ",91); put(" चल",134); put("णमा",89); put(" चर",93); put(" चन",91); put("ोल्",69); put(" अं",111); put("ोलि",69); put("ोला",99); put("ोलन",95); put(" अप",72); put(" अन",738); put(" अध",277); put(" अथ",96); put(" आक",83); put("ेता",128); put(" अल",77); put(" अर",427); put(" अम",148); put(" अभ",65); put("ोर्",161); put(" अस",323); put(" अव",627); put("ेत्",416); put(" अक",100); put(" अग",100); put(" अत",71); put(" अञ",333); put("ेपा",2443); put("ेन्",518); put("ोबा",73); put("थल ",101); put("ेना",77); put("ंग ",129); put("ेमा",93); put(" एउ",305); put("त् ",79); put("थम ",65); put(" इल",78); put(" इन",145); put("ेली",90); put("ेला",163); put("तो ",127); put(" आर",92); put(" आय",68); put(" आन",91); put(" आद",140); put(" आध",94); put(" आफ",173); put(" उह",329); put("ेर्",71); put(" उप",369); put(" उन",300); put(" उद",118); put(" उत",328); put("ेरि",117); put(" उच",89); put("ेरै",136); put("ंघ ",125); put(" वा",585); put(" वी",67); put(" वि",1830); put(" वु",93); put("्तर",540); put(" व्",234); put(" शर",146); put("ं ",520); put("ैशा",79); put(" वै",119); put(" शब",115); put(" शु",75); put("्तो",97); put(" सं",1338); put("्त्",507); put(" शि",206); put(" शा",289); put("्तै",88); put(" शह",107); put("्थल",136); put("्ता",424); put(" सक",211); put("्ती",153); put(" श्",338); put("ताक",144); put("्ति",514); put("्तु",122); put("्थ्",92); put("तान",131); put("्दछ",254); put("्थि",236); put("ताम",82); put("्था",656); put("तार",119); put("ताल",259); put("तिक",679); put("्थी",106); put("ताह",141); put("्दो",111); put("्द्",640); put(" वट",348); put("तिन",112); put("तिम",220); put("ँ ",497); put("तिब",72); put("्दा",387); put("तिल",64); put(" वर",390); put("्दी",92); put("्दि",109); put("तिर",95); put("्दू",82); put("तीक",85); put("तिह",119); put(" वन",80); put("्दै",77); put("्दे",123); put("्ट्",320); put(" लग",144); put("्टी",291); put("्टा",74); put(" लल",75); put("्डल",215); put(" लु",106); put(" ला",569); put(" लि",251); put(" ले",262); put("इ ",252); put(" लो",97); put("्डक",81); put("्णक",65); put(" या",166); put(" यस",2003); put(" यह",103); put(" यि",70); put("धन ",65); put(" यु",243); put(" यो",2991); put("्तक",221); put(" रा",1721); put(" रह",505); put(" रे",111); put(" रू",232); put("दै ",146); put(" रु",253); put(" रो",152); put("्बन",84); put("दी ",721); put("्बि",65); put("्मक",109); put("्मन",119); put("्यक",669); put("्मा",313); put("्मि",89); put("्मी",132); put("्यत",93); put("्मे",80); put("्यम",169); put("्रक",2903); put("्यव",169); put("्यस",223); put("्यह",70); put("्रज",90); put("्यु",227); put("्या",1225); put(" हो",3798); put("्धा",79); put("्धि",77); put("्धु",64); put("तया",66); put(" हि",324); put(" हा",314); put(" हु",1822); put(" हे",105); put("्ने",717); put("्नु",381); put("तरी",81); put("्ना",84); put("तरा",100); put("्नो",104); put(" सम",2258); put(" सभ",305); put(" सब",222); put("्पन",76); put(" सन",367); put("्पत",195); put(" सर",306); put("दा ",445); put(" सद",429); put(" सत",75); put("तर्",239); put(" स्",1058); put(" हर",182); put("्फब",94); put(" सो",117); put("्पा",1027); put(" सा",1310); put(" सि",468); put(" सह",215); put(" से",264); put("्प्",73); put(" सु",497); put(" सू",97); put("दि ",71); put(" दल",430); put(" दर",95); put(" दु",249); put(" दा",223); put("ोक ",69); put(" दि",387); put(" दक",141); put(" त्",468); put(" ते",64); put(" था",199); put(" थि",1391); put(" तर",320); put(" तथ",624); put(" ता",221); put("्क्",76); put(" ति",156); put("ोग ",226); put("तमा",143); put("्को",75); put(" ती",93); put("्का",162); put("्कृ",122); put("्की",66); put("ण्ड",575); put("ैनि",66); put(" ठु",72); put(" ठू",98); put(" डा",80); put("ँको",90); put(" टे",70); put("ैभन",80); put("तपु",159); put(" ५ ",87); put(" ठा",328); put("तन्",137); put(" ४ ",90); put("७१ ",81); put(" मो",133); put(" मे",182); put("्जा",70); put(" मा",2199); put(" मि",226); put(" मी",71); put(" मु",393); put("्जी",68); put("्छ।",1182); put(" मह",623); put(" भो",79); put(" मन",295); put(" भे",81); put(" मध",395); put("ैमा",131); put(" भु",80); put(" मण",175); put(" भू",134); put(" भि",128); put(" भा",1679); put(" मज",70); put(" भर",94); put(" ब्",200); put(" भद",64); put(" बे",149); put(" भन",724); put(" बै",74); put(" बो",103); put("्ञा",169); put(" बा",593); put(" बि",392); put(" मं",65); put(" बी",67); put(" बु",143); put(" भग",64); put(" बह",81); put(" बस",196); put("्टर",85); put(" फ्",93); put(" भए",2250); put(" बर",162); put("दल ",217); put(" बन",332); put(" फा",77); put(" बज",106); put("तथा",612); put(" बढ",88); put(" प्",5303); put(" पो",110); put(" फल",67); put(" पि",113); put(" पा",1007); put(" पु",600); put(" पे",81); put(" पृ",77); put(" पू",312); put("ौं ",109); put(" पर",802); put(" पश",191); put(" पह",651); put(" पछ",122); put(" पन",637); put(" पद",103); put("णाल",87); put(" पत",3652); put("ौँ ",65); put(" न्",72); put(" नै",168); put(" नि",657); put(" ना",582); put(" पं",74); put("्चल",413); put(" ने",2763); put(" धे",138); put("्छन",169); put(" नय",92); put(" नर",78); put("्चि",231); put(" नव",75); put("्चा",256); put(" धा",133); put("्। ",184); put(" नद",186); put(" दै",64); put(" दे",732); put(" धन",78); put(" द्",298); put(" दो",108); put(" धर",161); put(" नग",197); put("थ ",223); put("दछ।",89); put("द ",562); put("ध ",304); put("दछन",85); put("न ",5506); put("ड ",307); put(" छ ",575); put("ठ ",146); put("थाल",88); put("थिए",221); put("थाप",321); put("ण ",876); put("थान",166); put("थिय",1145); put("त ",3231); put("थित",211); put("धी ",65); put("ज ",416); put("दक्",143); put("ट ",1241); put("धि ",82); put("ं",3288); put("ः",73); put("ँ",2200); put("आ",1341); put("इ",1404); put("अ",4126); put("ऋ",113); put("ई",1594); put("उ",3478); put("घ ",163); put("ए",6874); put("ओ",539); put("ऐ",69); put("ग",8111); put("ख",2732); put("क",41084); put("औ",111); put("छ",5495); put("च",3790); put("ङ",845); put("घ",968); put("ट",4637); put("ञ",822); put("झ",319); put("ज",7684); put("ठ",1551); put("ङ ",292); put("ड",2764); put("ढ",364); put("ण",2637); put("त",20032); put("थ",4532); put("द",12121); put("ध",3905); put("न",29922); put("प",22723); put("फ",1251); put("्ग ",136); put("ब",5465); put("भ",7912); put("म",22298); put("य",17139); put("र",42105); put("ल",18318); put("व",12132); put("ष",4104); put("श",6654); put("ह",13763); put("स",20352); put("ि",29268); put("ा",66742); put("े",14995); put("थवा",92); put("ू",2666); put("ृ",815); put("ी",11554); put("च ",186); put("ु",12537); put("ौ",1228); put("्",49626); put("ो",28329); put("ै",2713); put("।",9235); put("०",2064); put("१",1785); put("्क ",72); put("छ ",1403); put("६",623); put("७",619); put("८",678); put("९",972); put("२",2170); put("३",565); put("४",638); put("५",791); put("क ",5557); put("ेल ",167); put("ग ",763); put("ख ",276); put("ेर ",327); put("त्स",67); put("त्व",197); put("त्प",68); put("त्र",5347); put("त्य",758); put("त्त",449); put("ए ",239); put("तीय",69); put("द् ",189); put("ेस ",70); put("उ ",287); put("ई ",1278); put("ेश ",318); put("ै ",1366); put("्न ",467); put("नै ",335); put(" ख",612); put(" ग",3519); put(" औ",90); put(" क",6153); put(" ओ",97); put(" ऐ",65); put(" ट",271); put(" ज",3597); put(" झ",164); put(" च",1230); put(" छ",2605); put(" घ",502); put(" इ",461); put(" आ",1284); put(" अ",3988); put(" ए",2988); put(" ऋ",77); put(" उ",1784); put(" ई",92); put("दार",162); put("नो ",211); put("दान",85); put("दीक",207); put("दिर",84); put("े ",3604); put("दिन",243); put("न् ",626); put("दुई",79); put("ौँम",309); put("दुर",326); put("ेकप",97); put("्म ",374); put("ू ",585); put("ेका",344); put("ेको",828); put("्य ",1998); put("ेखि",464); put("्र ",942); put("ेखा",65); put("ि ",3525); put("नी ",612); put("ेटि",110); put("ी ",7016); put("नु ",137); put("ोत्",73); put("ु ",1173); put("ा ",19102); put("ँउ ",227); put(" ८",76); put(" ९",73); put(" ६",100); put(" ७",169); put(" ४",169); put(" ५",165); put(" २",1308); put(" ३",186); put(" ०",277); put(" १",1083); put(" ।",2222); put("्व ",234); put("ेजी",71); put("दस्",318); put(" प",14289); put(" फ",558); put(" न",5247); put(" म",5367); put(" य",5733); put("्ष ",268); put(" ब",2996); put(" भ",5836); put(" ढ",70); put(" ठ",526); put(" ड",306); put("ह ",271); put(" द",2964); put(" ध",656); put(" त",2303); put(" थ",1702); put(" ह",6806); put(" स",10170); put(" ल",1764); put(" र",4971); put(" श",1531); put(" व",3977); put("ने ",1547); put("्स ",116); put("स ",1459); put("ष ",373); put("थ्य",109); put("श ",446); put("्छ ",694); put("व ",550); put("्च ",74); put("दरम",107); put("्ट ",232); put("ल ",2508); put("दलह",69); put("नि ",671); put("दर्",91); put("दलक",97); put("ना ",698); put("ँग ",83); put("र ",6666); put("्ड ",120); put("य ",3205); put("्ठ ",89); put("म ",1712); put("्ण ",171); put("ोखर",85); put(" र ",1581); put("ब ",130); put("्थ ",94); put("फ ",86); put("्त ",382); put("्ध ",250); put("प ",228); put("ो। ",2741); put("्द ",129); put("ृष्",136); put("डल ",72); put("डी ",201); put("डा ",124); put("ञ्ज",95); put("ञ्च",499); put("ृति",122); put("ृत्",80); put("ञान",153); put("ेत ",110); put("ठमा",517); put("ट्र",339); put("ट्ट",87); put("ढी ",85); put("ेक ",82); put("अक्",91); put("टिन",116); put("अञ्",333); put("टीक",104); put("ुवा",235); put("ूको",117); put("ुला",154); put("ुलो",69); put("ुल्",89); put("ुले",184); put("ुरा",226); put("ुरो",69); put("ुर्",237); put("ुरी",67); put("ुरु",159); put("ुरम",86); put("ुम्",151); put("ुरक",79); put("ुमा",298); put("णी ",110); put("ँदै",80); put("ुभय",124); put("णा ",67); put("डलक",101); put("ुभए",420); put("ुप्",75); put("ुपा",81); put("ुपम",101); put("ुन्",1483); put("ुनै",129); put("ुने",151); put("ुनु",515); put("ुनि",176); put("ुना",77); put("ुद्",231); put("्सा",87); put("्से",64); put("्ष्",65); put("ँमा",361); put("्स्",64); put("ठाउ",291); put("ठूल",104); put("्ला",1132); put("्लो",92); put("्ले",68); put("ंचा",97); put("्रद",218); put("्रथ",82); put("्रत",719); put("्रण",90); put("्रप",72); put("्रन",77); put("्ये",172); put("्रध",142); put("्रम",518); put("्यो",226); put("ंग्",118); put("्रय",179); put("्रव",165); put("्रश",109); put("्रह",151); put("्रस",389); put("्रा",928); put("ंगा",83); put("्रि",4096); put("्री",584); put("ठुल",72); put("्रै",117); put("्रे",422); put("्रो",266); put("्षक",74); put("ीहर",197); put("्षर",74); put("ंगठ",68); put("्षे",409); put("्षि",335); put("्षा",151); put("्षी",92); put("्वक",82); put("ुग्",67); put("्वत",106); put("्वर",184); put("्वव",84); put("्वम",76); put("्वय",164); put("्वी",175); put("्वा",1398); put("डौँ",365); put("डौं",74); put("ूला",68); put("ूलो",82); put("ति ",1256); put("ता ",557); put("णको",70); put("तु ",113); put("ूमि",65); put("ूमा",80); put("ती ",337); put("ूर्",396); put("ूपम",142); put("तै ",115); put("ते ",88); put("ूद्",136); put("ंमा",238); put("ंस्",240); put("तर ",294); put("ुस्",101); put("ुसा",127); put("ुहु",425); put("ंवि",168); put("ाला",279); put("ालि",277); put("ाली",1573); put("ाल्",175); put("ाले",372); put("छ। ",2152); put("ावि",101); put("ाशन",833); put("िकृ",90); put("िका",4480); put("ाशक",884); put("िको",207); put("िक्",271); put("ाषा",1077); put("ासन",94); put("ासद",191); put("ाष्",296); put("ाशि",795); put("ासक",88); put("ाही",67); put("ाहि",278); put("ाहा",83); put("ुन ",257); put("ासि",356); put("ासी",103); put("ाहर",380); put("ास्",236); put("जा ",203); put("चलक",256); put("िज्",95); put("चर्",65); put("िजय",135); put("जी ",92); put("ुर ",568); put("ङ्ग",239); put("ितप",65); put("छन्",559); put("िता",146); put("िति",411); put("ित्",493); put("िद्",368); put("िधि",130); put("िधा",249); put("िना",260); put("िनि",160); put("िनी",149); put("िने",242); put("िनु",78); put("िन्",1022); put("चीन",87); put("िभि",96); put("िभा",91); put("ियन",73); put("िम्",132); put("ियम",114); put("िमा",914); put("ियो",1315); put("िया",360); put("िर्",332); put("िरा",176); put("िले",173); put("िल्",1069); put("िलो",573); put("चित",254); put("िला",204); put("चाय",66); put("चार",351); put("चाल",100); put("चिव",79); put("चिन",100); put("चिम",183); put("िष्",174); put("िश्",356); put("िशे",71); put("िवा",232); put("ीका",189); put("ीको",490); put("िहा",169); put("िस्",142); put("ूल ",110); put("ीति",294); put("च्च",109); put("जमा",145); put("ीद्",108); put("छोर",78); put("जन्",230); put("जनक",98); put("जनत",72); put("जधा",122); put("जनव",107); put("जनै",185); put("जनी",264); put("जना",168); put("जदु",67); put("ीमा",357); put("ीया",65); put("ुक्",205); put("ुको",176); put("ुका",171); put("ुख्",130); put("ृत ",152); put("ीले",86); put("ीला",83); put("जस्",157); put("जसल",64); put("ित ",1545); put("िण ",71); put("जिल",993); put("जिक",146); put("जार",186); put("जान",79); put("जात",246); put("जर्",77); put("जयी",89); put("ाँउ",242); put("ाँच",67); put("ाँक",137); put("िन ",363); put("जवा",81); put("ाइन",178); put("िल ",92); put("जोड",89); put("ाउँ",218); put("ाउं",237); put("ाउन",366); put("ीक ",78); put("ज्य",351); put("ाँस",67); put("ांग",75); put("ज्ञ",223); put("ाँल",66); put("िम ",169); put("िय ",243); put("िर ",148); put("जील",69); put("जीव",121); put("ाएक",100); put("जुन",124); put("टर ",108); put("िव ",68); put("िस ",86); put("ाग्",194); put("ागु",64); put("ागि",189); put("ीत ",128); put("ागर",78); put("ागम",84); put("ाको",3606); put("ाक्",157); put("ाका",303); put("ाओव",397); put("ाडी",141); put("िंह",72); put("ाठम",478); put("ाटन",82); put("टी ",233); put("टा ",741); put("ाजा",131); put("ाजि",146); put("ाज्",244); put("ाजन",456); put("ाजध",126); put("ाजव",83); put("ीन ",153); put("ाचन",103); put("ाङ्",108); put("ुई ",73); put("ाने",97); put("ाना",169); put("ानि",283); put("ानी",322); put("ानु",103); put("ानव",65); put("ुख ",149); put("ानस",161); put("ानम",146); put("ाध्",103); put("ापन",228); put("ान्",702); put("ानो",110); put("ादे",93); put("ादी",738); put("ादु",180); put("ादन",914); put("ानक",94); put("ाद्",158); put("ाति",178); put("ाता",140); put("ाती",68); put("ाण्",134); put("ात्",408); put("ादक",75); put("ीय ",427); put("ाडौ",440); put("ारी",407); put("ारि",163); put("ारा",1342); put("ार्",2184); put("ारे",69); put("ालक",765); put("ालम",256); put("ालय",324); put("ालद",78); put("ामा",889); put("ायक",72); put("ाम्",197); put("ायण",151); put("ायत",156); put("ाया",71); put("ारक",244); put("ारम",182); put("ारण",184); put("ारत",376); put("ाबा",106); put("िएक",373); put("ामक",80); put("ामय",74); put("ामम",66); put("ापा",186); put("ाप्",232); put("ुङ ",64); put("ंघ",232); put("ँस",83); put("ौ ",65); put("ंख",88); put("ंग",634); put("ंक",193); put("ँल",78); put("ंच",134); put("केन",240); put("ँद",154); put("ँड",80); put("ँम",363); put("ंस",389); put("ंह",86); put("ंव",201); put("् ",1181); put("ंत",94); put("ंम",241); put("केह",83); put("ँक",178); put("ो ",20357); put("ँग",166); put("ँच",76); put("ँउ",243); put("कृत",264); put("अस",341); put("अव",627); put("आक",84); put("अल",82); put("अर",461); put("अभ",65); put("आए",70); put("अम",151); put("घर ",251); put("अप",74); put("अध",281); put("अन",771); put("अथ",96); put("इत",80); put("ाइ ",156); put("इए",81); put("आय",68); put("आर",95); put("आफ",174); put("कृष",151); put("आद",141); put("आध",94); put("आन",112); put("ाई ",1080); put("अं",111); put("अञ",333); put("अत",71); put("अक",101); put("अग",107); put("उम",66); put("उप",377); put("उह",331); put("ऋत",72); put("इन",366); put("इर",70); put("इल",137); put("इस",102); put("उँ",251); put("उं",238); put("उक",79); put("उच",90); put("उट",311); put("उत",340); put("हो।",2612); put("उन",717); put("उद",141); put("कोट",86); put("एउ",305); put("एक",5494); put("एम",113); put("एप",66); put("क्क",84); put("क्त",425); put("क्य",129); put("क्न",67); put("क्ष",1267); put("क्र",426); put("क्स",110); put("ाँ ",310); put("ए।",67); put("एव",82); put("एर",147); put("एस",80); put("गर",2258); put("गल",135); put("गव",76); put("खे",215); put("गन",66); put("खो",112); put("गम",263); put("ख्",345); put("खा",431); put("गठ",95); put("खि",580); put("खी",82); put("खु",123); put("ाग ",123); put("गढ",68); put("गण",181); put("गत",326); put("गको",91); put("खर",150); put("क्",2722); put("खम",75); put("गक",127); put("कै",214); put("के",654); put("को",14452); put("कि",691); put("की",474); put("का",12832); put("कृ",425); put("कु",618); put("कू",91); put("कस",66); put("कव",78); put("कह",90); put("कल",273); put("कम",415); put("कर",463); put("कप",247); put("कन",76); put("कत",154); put("ाङ ",105); put("कक",112); put("ओव",398); put("चु",124); put("ची",172); put("चि",731); put("चा",795); put("छन",717); put("चौ",90); put("च्",216); put("चो",89); put("० ",345); put("जक",89); put("चन",324); put("ङ्",397); put("चर",129); put("चल",599); put("घा",108); put("गण्",66); put("ङम",69); put("गते",76); put("। ",7045); put("गा",955); put("गी",218); put("गि",310); put("गु",302); put("गो",351); put("गौ",84); put("ग्",809); put("गे",161); put("गै",75); put("घर",335); put("टन",160); put("ञ्",596); put("ञा",169); put("टा",992); put("टर",235); put("४ ",302); put("झा",105); put("३ ",263); put("टक",135); put("जो",225); put("जे",208); put("छ।",2479); put("जी",387); put("जु",351); put("जा",939); put("जि",1330); put("२ ",297); put("ज्",670); put("जन",1499); put("खान",74); put("जद",90); put("जध",126); put("छि",255); put("छा",205); put("जस",334); put("जव",93); put("१ ",351); put("जर",120); put("जल",76); put("गठन",79); put("छो",118); put("जय",160); put("जम",205); put("ठा",393); put("डक",133); put("ाथ ",102); put("५ ",351); put("ठन",83); put("टे",203); put("ठम",522); put("ट्",498); put("टो",148); put("टी",408); put("टि",258); put("डा",364); put("डि",270); put("डी",265); put("डल",256); put("६ ",313); put("ाद ",282); put("ठु",73); put("ठू",104); put("ढी",114); put("ढा",72); put("ाण ",70); put("णक",119); put("७ ",328); put("ड्",123); put("डौ",474); put("डो",86); put("डे",171); put("णि",132); put("णी",170); put("णा",196); put("ात ",197); put("तक",594); put("८ ",352); put("णम",93); put("तव",80); put("९ ",264); put("तह",110); put("ति",2878); put("ता",1722); put("तु",292); put("ती",680); put("तथ",624); put("तप",208); put("तन",233); put("तम",226); put("ण्",631); put("तय",73); put("तल",91); put("तर",935); put("थव",101); put("दछ",271); put("था",1584); put("थी",140); put("थि",1694); put("ते",197); put("तै",125); put("तो",181); put("थम",91); put("त्",7154); put("थल",165); put("खेल",103); put("दक",289); put("दस",347); put("दू",145); put("दु",584); put("दी",1175); put("दि",689); put("दा",996); put("दन",1011); put("दव",74); put("दल",480); put("दर",324); put("दम",71); put("थ्",174); put("नज",74); put("धा",907); put("नत",94); put("नद",266); put("धी",98); put("धि",828); put("ान ",852); put("धु",156); put("दो",255); put("दौ",70); put("द्",2831); put("दे",1366); put("धन",183); put("दै",256); put("नक",650); put("नग",337); put("धर",218); put("नर",137); put("नल",223); put("नव",289); put("ाज ",178); put("धे",169); put("नन",100); put("नप",96); put("नब",64); put("नय",150); put("नम",477); put("ध्",787); put("पं",75); put("नी",1179); put("नु",1548); put("ने",4740); put("नस",329); put("नह",97); put("ना",2286); put("नि",2559); put("पक",159); put("नो",316); put("नै",540); put("न्",7416); put("पत",4116); put("पन",1101); put("पद",120); put("न।",118); put("पछ",277); put("पट",80); put("पश",213); put("पह",665); put("पस",130); put("पल",132); put("पम",272); put("पर",1026); put("पे",166); put("पू",427); put("पृ",79); put("पा",5213); put("पि",272); put("पी",141); put("पु",1182); put("फल",131); put("फर",70); put("प्",6004); put("फब",94); put("पो",196); put("बन",449); put("फे",70); put("बत",86); put("फु",76); put("बढ",88); put("फू",67); put("फा",131); put("बज",120); put("फ्",316); put("भए",2692); put("बर",285); put("बल",88); put("भक",78); put("भग",82); put("बस",232); put("बह",195); put("बि",521); put("बा",1458); put("बु",218); put("मं",75); put("बी",142); put("भद",79); put("भन",878); put("बे",211); put("गरम",92); put("बै",272); put("बो",141); put("गरप",94); put("भय",191); put("भर",147); put("गरे",321); put("ब्",486); put("मक",339); put("गरी",134); put("गरि",502); put("मग",77); put("मज",101); put("भि",375); put("भा",2323); put("मत",163); put("मण",318); put("भू",158); put("भु",153); put("गर्",821); put("मन",572); put("भे",108); put("मध",481); put("मद",72); put("भो",89); put("मप",65); put("मल",187); put("यक",819); put("मम",151); put("भ्",133); put("मय",212); put("मर",128); put("मस",126); put("मह",673); put("मृ",68); put("यत",299); put("मू",114); put("यण",158); put("ख्य",245); put("यद",91); put("मि",1113); put("मा",10729); put("ाट ",785); put("मु",840); put("मी",348); put("रं",73); put("मो",273); put("यम",527); put("म्",2421); put("मे",530); put("यन",231); put("यप",89); put("मै",88); put("यव",183); put("रख",100); put("रग",116); put("रक",3696); put("यल",80); put("यर",101); put("या",2168); put("रज",106); put("यह",189); put("रच",84); put("गमा",170); put("यस",2268); put("रध",173); put("रद",310); put("रथ",102); put("रत",1236); put("रण",521); put("यु",657); put("यी",175); put("यि",191); put("रय",191); put("रम",1296); put("रभ",77); put("रब",131); put("यो",5061); put("रप",226); put("रन",174); put("ये",226); put("लम",462); put("लय",351); put("लब",81); put("लद",123); put("लन",243); put("गाउ",130); put("लच",65); put("लग",235); put("लक",1487); put("र्",6868); put("रो",703); put("रै",297); put("रे",1245); put("गाँ",224); put("रू",1254); put("री",1735); put("रु",1451); put("रि",5597); put("रा",5311); put("रह",868); put("रस",574); put("रश",114); put("रव",321); put("रल",193); put("वं",88); put("िक ",1742); put("ल्",1854); put("लो",1078); put("चन ",69); put("ले",2083); put("लु",247); put("ली",1940); put("लि",1013); put("ला",3708); put("लल",168); put("लह",138); put("लस",69); put("शब",122); put("वै",233); put("शन",968); put("वे",271); put("षक",102); put("शम",116); put("व्",325); put("शर",176); put("वह",113); put("वव",90); put("वस",368); put("वु",106); put("वा",3817); put("वि",2520); put("वी",434); put("वप",72); put("वन",350); put("वध",419); put("शक",1037); put("वल",144); put("वर",826); put("वय",169); put("वम",117); put("वक",170); put("वत",227); put("वट",383); put("ाह ",84); put("सन",601); put("षे",417); put("सप",72); put("सभ",377); put("सब",248); put("ष्",905); put("सम",2673); put("सर",429); put("सल",312); put("सव",65); put("हक",127); put("सच",90); put("षा",1291); put("षि",415); put("षी",120); put("िङ ",81); put("ास ",619); put("सत",83); put("सद",673); put("शे",152); put("श्",1168); put("षर",77); put("सग",64); put("सक",2028); put("शह",143); put("सं",1482); put("शी",150); put("शु",136); put("शा",630); put("शि",1111); put("सँ",111); put("षण",89); put("हे",701); put("हु",2366); put("ही",279); put("हि",1570); put("हा",1720); put("िए ",165); put("ाम ",560); put("ह्",87); put("हो",3850); put("से",478); put("हन",162); put("सु",586); put("सी",345); put("हत",108); put("सू",105); put("सि",1173); put("चल ",150); put("सा",2163); put("सह",275); put("हज",68); put("हल",85); put("स्",3576); put("हर",1967); put("सै",149); put("सो",307); put("ात",1181); put("ाथ",320); put("ाण",404); put("ाठ",517); put("िं",132); put("ाड",760); put("ाल ",1016); put("ाट",1019); put("ाब",231); put("ाभ",93); put("ाप",949); put("ान",3357); put("ाद",2589); put("ाध",265); put("गुर",71); put("िख",71); put("ाव",435); put("िक",7298); put("ाल",5422); put("ार",6852); put("ाय",812); put("ाम",2329); put("िए",681); put("िज",372); put("ाह",1078); put("िच",143); put("िङ",184); put("ास",1934); put("ाष",1391); put("ाश",2631); put("िग",115); put("ां",267); put("ाँ",1104); put("ाइ",698); put("ाई",1298); put("ाउ",964); put("ाओ",403); put("ाक",4316); put("ाए",185); put("गुन",74); put("ाच",265); put("ाज",1659); put("ाग",1013); put("ाख",288); put("ाङ",244); put("ाघ",70); put("ार ",1305); put("ुँ",124); put("ीद",163); put("गिर",76); put("ुई",88); put("ीत",508); put("ीप",148); put("ीन",313); put("ीम",461); put("ीय",520); put("ीब",79); put("ील",304); put("ीर",227); put("ुग",188); put("ुख",347); put("ीव",147); put("गीत",100); put("ुक",691); put("ीह",209); put("ीस",78); put("ुङ",145); put("ुट",214); put("िट",172); put("ाय ",70); put("िण",163); put("ित",2827); put("िद",484); put("गाय",88); put("िध",410); put("िन",2481); put("िप",245); put("िब",181); put("िभ",260); put("िम",1517); put("िर",1038); put("िय",2231); put("िल",2254); put("ीक",872); put("िश",533); put("िव",468); put("िस",542); put("िष",301); put("िह",253); put("ेव",427); put("ेश",820); put("ेल",681); put("सला",171); put("ेर",844); put("ेम",230); put("ेब",84); put("ेप",2592); put("सले",93); put("ेन",806); put("ैत",257); put("ैज",79); put("ेह",196); put("ेस",274); put("ेष",206); put("ैश",81); put("ैर",64); put("ैल",110); put("ैभ",84); put("ैम",134); put("ैन",181); put("ेक",1516); put("ेख",723); put("ेट",234); put("ेड",98); put("ेत",801); put("ेद",151); put("ेग",72); put("ेज",215); put("समु",85); put("समि",387); put("समा",459); put("ृथ",65); put("ृत",389); put("ृष",194); put("गोर",127); put("सरक",167); put("गोल",71); put("समे",69); put("सम्",1386); put("ुत",130); put("ुण",70); put("ुन",2984); put("ुद",383); put("ुब",76); put("ुप",397); put("ुर",1722); put("ुम",556); put("ुभ",589); put("ूक",155); put("ग्ल",85); put("ुल",730); put("ुष",88); put("ुस",363); put("ुव",409); put("ग्र",367); put("ुश",84); put("ुह",538); put("सर्",105); put("ग्न",160); put("ूद",147); put("ून",67); put("ूप",214); put("ूम",171); put("ूर",453); put("ूल",388); put("ूह",74); put("सबै",187); put("्व",2939); put("्श",82); put("्ष",1678); put("्स",579); put("्ह",81); put("्भ",100); put("्म",1441); put("्य",5693); put("्र",13669); put("्ल",1547); put("्।",480); put("समय",115); put("ष्म",69); put("ष्ण",122); put("ष्ठ",171); put("ष्ट",483); put("सभा",365); put("सद्",160); put("ौत",91); put("ोर",513); put("ोल",515); put("सदस",314); put("ोब",119); put("ोम",148); put("ोस",122); put("ोह",153); put("सदर",107); put("ोश",104); put("ोव",69); put("्ण",427); put("्त",3287); put("्ड",711); put("्ट",1245); put("्ठ",192); put("्ञ",223); put("्फ",210); put("्ब",412); put("्प",1700); put("्ध",702); put("्न",1912); put("षेत",396); put("्थ",1433); put("ो।",3741); put("्द",2288); put("ौल",71); put("ौर",128); put("्ज",453); put("्छ",2152); put("्च",1134); put("्ग",579); put("्ख",113); put("्क",866); put("सन्",376); put("ोज",238); put("ौं",159); put("ोड",185); put("ोट",228); put("ौँ",401); put("ोद",66); put("ोत",169); put("ोप",186); put("ोध",78); put("ोन",98); put("ोख",109); put("ोक",287); put("ोग",453); put("हत्",91); put("सेन",118); put("छन ",99); put("सुन",123); put("सिर",66); put("सिम",95); put("सिन",119); put("सुर",172); put("साह",147); put("सिद",138); put("सान",163); put("साद",218); put("साप",131); put("सार",311); put("साम",357); put("सिक",403); put("साल",247); put("सिं",91); put("साथ",94); put("सहर",108); put(" १८",152); put(" १९",516); put(" २०",1012); put("०६",103); put("०४",114); put("०५",217); put("०२",500); put("०३",93); put("००",262); put("०१",255); put("१०",116); put("१५",81); put("१७",82); put("१८",226); put("१२",66); put("१४",88); put("१९",555); put("२०",1126); put(" ७१",72); put("हरू",762); put("हरु",794); put("हरि",77); put("ङमा",65); put("७१",90); put("स्व",373); put("९०",64); put("छि ",189); put("९६",77); put("९५",70); put("९८",66); put("९१",112); put("स्र",74); put("स्य",402); put("स्न",77); put("स्थ",1019); put("स्प",226); put("स्ट",105); put("स्त",727); put("९९",85); put("स्क",351); put("२३",69); put("२२",66); put("२५",83); put("२७",122); put("२६",80); put("२९",70); put("२८",115); put("सोज",81); put("सेव",93); put(" १०",76); put(" ०५",134); put("हेक",471); put("हेन",82); put("जन ",98); put("हुन",2172); put("हुँ",68); put("हिम",124); put("हिल",691); put("हिन",285); put("हित",161); put("हास",142); put("हिक",125); put("हाल",183); put("हार",140); put("हान",72); put("हाद",225); put("हाड",113); put("हाँ",430); put("चना",64); put("चन्",135); put("सचि",83); put("सकि",79); put("सका",115); put("सको",1596); put("सक्",148); put("कै ",184); put("का ",4257); put("कि ",84); put("षाक",932); put("की ",394); put("षिण",127); put("हो ",1122); put("षिक",187); put("ओवा",396); put("शेष",71); put("हा ",81); put("ही ",218); put("श्व",419); put("श्र",376); put("श्य",86); put("श्च",215); put("शहर",129); put("सी ",177); put("हर ",124); put("संग",215); put("संख",67); put("संघ",224); put("संव",197); put("संस",296); put("शाख",89); put("शित",796); put("शाह",92); put("शास",187); put("सँग",107); put("शिक",120); put("सो ",69); put("शार",66); put("वैश",69); put("वेश",81); put("वुल",80); put("शर्",111); put("सा ",76); put("व्य",273); put("शब्",114); put("वर्",460); put("षा ",211); put("किन",120); put("काम",260); put("कार",2072); put("काल",377); put("किक",104); put("काश",2575); put("कास",405); put("किस",96); put("कुन",166); put("कुर",99); put("कुम",159); put("ववि",79); put("शको",75); put("कान",97); put("काठ",489); put("काक",1844); put("वस्",272); put("वहा",72); put("सन ",103); put("गि ",141); put("वाद",803); put("वान",150); put("वाच",132); put("विक",476); put("वाल",112); put("वास",237); put("कला",91); put("वार",1366); put("वाम",64); put("वित",78); put("विन",80); put("विद",224); put("विध",297); put("विज",192); put("वाह",64); put("गी ",84); put("विष",89); put("विश",380); put("विस",90); put("विम",83); put("विर",102); put("विभ",130); put("वीर",70); put("कम्",158); put("कमा",129); put("कर्",161); put("गा ",93); put("करण",105); put("कपु",78); put("कपा",103); put("वधि",404); put("कता",70); put("वमा",91); put("गर ",180); put("वयम",124); put("सं ",192); put("शी ",67); put("गत ",162); put("खि ",378); put("वटा",364); put("खी ",68); put("खा ",132); put("को ",13998); put("शन ",893); put("वि ",102); put("एमा",79); put("वा ",501); put("वी ",188); put("ल्न",81); put("ल्प",107); put("ल्य",159); put("ल्ल",1131); put("एवं",67); put("एकी",88); put("एका",367); put("एकि",98); put("एको",2830); put("लोक",92); put("लेख",158); put("शक ",887); put("लेक",101); put("लेट",101); put("लिम",70); put("लुम",71); put("वर ",134); put("लाई",880); put("लाइ",94); put("लाग",378); put("लाक",490); put("लाम",331); put("लाल",114); put("लिक",155); put("लाह",236); put("लिङ",98); put("लित",141); put("लिन",92); put("वन ",146); put("लहर",130); put("एउट",304); put("ललि",72); put("लमा",361); put("लद्",81); put("लका",156); put("वं ",67); put("लगा",129); put("लको",1159); put("लक्",65); put("रैम",78); put("रेस",80); put("रेष",101); put("रोप",82); put("रोग",68); put("र्श",68); put("र्व",558); put("र्स",92); put("र्ष",409); put("र्म",544); put("र्य",1351); put("र्थ",286); put("र्द",429); put("र्न",750); put("र्फ",154); put("र्ट",316); put("र्ण",301); put("र्त",237); put("र्ग",285); put("र्ख",68); put("र्क",192); put("र्ज",198); put("र्छ",112); put("र्च",149); put("रीक",121); put("रिव",148); put("रिय",408); put("रीम",87); put("रीय",210); put("रुक",171); put("रुम",97); put("रुप",191); put("रुल",94); put("रूक",141); put("रूद",136); put("रूप",207); put("रूम",82); put("रूल",87); put("रेक",307); put("रेज",78); put("रेल",67); put("रेर",97); put("रेन",80); put("रसा",265); put("रसि",109); put("रहे",467); put("रहर",171); put("रस्",71); put("ले ",1440); put("राई",127); put("रान",448); put("राप",77); put("रात",83); put("राण",115); put("राख",96); put("राज",1244); put("राक",104); put("रिन",282); put("रित",70); put("राष",293); put("राह",72); put("राम",287); put("रिए",176); put("राय",214); put("राल",136); put("रिक",3842); put("लो ",852); put("रला",76); put("लि ",69); put("ला ",807); put("रयो",160); put("रम्",75); put("रमा",715); put("रमु",241); put("रवा",142); put("रले",64); put("ली ",1594); put("रधा",161); put("येक",79); put("रदे",155); put("रमण",71); put("यो।",1126); put("रबा",70); put("योग",340); put("रपा",108); put("युक",77); put("युर",75); put("युन",112); put("युद",113); put("याङ",69); put("याक",103); put("याम",150); put("यान",128); put("याप",111); put("यात",120); put("याद",68); put("यास",84); put("यिक",111); put("याल",253); put("यार",124); put("याय",70); put("यिन",65); put("रति",595); put("रत्",114); put("रथम",70); put("लय ",258); put("युव",76); put("रतक",192); put("रणा",86); put("यसक",1478); put("यसै",79); put("यसल",145); put("रगत",68); put("यवस",100); put("रक्",100); put("रको",493); put("रजा",74); put("याँ",127); put("यहा",98); put("यस्",93); put("लन ",125); put("रे ",127); put("महे",70); put("महा",221); put("महि",223); put("महत",77); put("यको",226); put("यक्",275); put("रू ",452); put("रु ",592); put("यका",195); put("मले",67); put("री ",1056); put("मुद",90); put("मुख",298); put("मुक",206); put("मिल",98); put("मित",526); put("मिन",83); put("मार",349); put("माल",263); put("मिक",100); put("रो ",251); put("मास",338); put("मिट",74); put("माण",135); put("माड",449); put("माध",70); put("माथ",111); put("मात",198); put("मान",717); put("माओ",399); put("माक",73); put("माज",262); put("रै ",187); put("मोर",76); put("यन्",64); put("यद्",67); put("मेत",64); put("मेर",107); put("मेल",71); put("रका",2994); put("यमि",88); put("ऋतु",72); put("म्र",98); put("म्य",162); put("यमा",180); put("म्प",1201); put("म्ब",311); put("म्म",335); put("रत ",106); put("मको",161); put("रण ",320); put("या ",441); put("उहा",325); put("यी ",158); put("भिन",116); put("भित",82); put("भाव",75); put("यो ",3433); put("भास",199); put("भाष",1089); put("भार",394); put("भाग",184); put("उपत",120); put("रम ",92); put("मजद",66); put("ये ",122); put("मध्",444); put("मना",80); put("मन्",256); put("भूम",78); put("मण्",216); put("मती",69); put("मयि",71); put("रा ",1447); put("०० ",67); put("रि ",116); put("ममा",144); put("मा ",6826); put("बर्",135); put("यत ",118); put("भक्",69); put("मी ",185); put("यन ",118); put("बस्",105); put("बहा",133); put("बाल",77); put("बाह",65); put("बास",89); put("बिन",70); put("बाट",745); put("बाग",79); put("बार",117); put("बिह",66); put("यम ",171); put("बेल",114); put("यस ",334); put("भनि",212); put("भने",219); put("भन्",420); put("बैभ",80); put("भयो",166); put("ब्र",111); put("ब्य",100); put("ब्द",140); put("एर ",132); put("प्य",67); put("प्र",5545); put("प्त",252); put("भा ",133); put("मन ",82); put("बजा",98); put("मय ",66); put("यक ",69); put("बने",91); put("बना",154); put("बन्",175); put("एक ",2017); put("भएक",2580); put("फ्न",128); put("फ्र",99); put("आदि",87); put("पहि",540); put("पहा",109); put("पश्",183); put("आन्",94); put("पर्",460); put("आफ्",129); put("इएक",72); put("२०२",474); put("परि",275); put("२०१",229); put("परा",119); put("२००",176); put("पमा",255); put("�",311); put("फबा",94); put("पोख",90); put("उन ",91); put("पृथ",65); put("पुस",117); put("पूर",347); put("पुग",79); put("पुर",744); put("पित",80); put("पाक",119); put("पान",108); put("पात",131); put("पाद",966); put("पार",420); put("पाल",2675); put("पाइ",114); put("बै ",101); put("अथव",91); put("१९१",90); put("१९९",68); put("१९६",68); put("अधि",111); put("अनि",120); put("अनु",226); put("अध्",166); put("अन्",365); put("न्च",76); put("न्छ",1928); put("न्त",1150); put("न्ट",89); put("न्ध",228); put("न्न",383); put("न्थ",109); put("न्द",1479); put("न्य",282); put("न्म",233); put("न्स",147); put("न्।",473); put("नैत",179); put("अमे",66); put("अरू",140); put("अर्",230); put("अवस",167); put("अवध",415); put("पनी",71); put("पना",230); put("पनि",614); put("पन्",133); put("असो",81); put("अस्",166); put("पत्",3819); put("पति",105); put("पता",130); put("पछि",199); put("पा ",229); put("नले",102); put("नया",92); put("नवा",108); put("नन्",74); put("०२७",93); put("०२८",90); put("नदी",180); put("धेर",139); put("नमा",333); put("ध्य",728); put("नुह",426); put("उटा",296); put("नुप",72); put("नुभ",561); put("नुस",135); put("निस",101); put("निष",82); put("नीत",296); put("नेप",2459); put("नेत",159); put("नेक",221); put("फल ",80); put("उनी",101); put("उनु",99); put("उने",183); put("उनल",77); put("उद्",70); put("उनक",91); put("नस्",108); put("निर",312); put("निय",235); put("निम",64); put("निन",391); put("उत्",329); put("निध",76); put("नाल",106); put("निक",384); put("नाम",395); put("नार",232); put("नाथ",91); put("नाक",103); put("नाउ",100); put("नाइ",96); put("द्द",65); put("द्व",1093); put("द्र",692); put("द्य",285); put("द्ध",407); put("धर्",124); put("नकप",71); put("इने",87); put("इन्",241); put("नका",130); put("नको",327); put("इला",81); put("देख",530); put("देव",249); put("देश",451); put("दैन",81); put("१८ ",75); put("दोल",117); put("२७ ",96); put("धित",72); put("धिम",418); put("धार",244); put("धिक",138); put("धान",515); put("२८ ",93); put("नता",76); put("नगर",305); put("न। ",91); put("उंम",222); }};
    private static final int[] n_words_s = {614665,704688,490631};
    private static final String name_s = "ne";

    public Profile_ne() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
