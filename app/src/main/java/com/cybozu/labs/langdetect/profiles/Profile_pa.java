package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_pa extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>() {{ put("ਾਜ਼",17); put("ਾਜਧ",12); put("ਾਜਾ",13); put("ੀਲ ",18); put("D",18); put("E",20); put("F",29); put("G",23); put("A",52); put("B",35); put("C",59); put("L",38); put("M",47); put("N",37); put("O",37); put("H",31); put("I",60); put("U",14); put("T",45); put("W",18); put("P",47); put("S",55); put("R",24); put("f",103); put("g",125); put("d",221); put("e",655); put("b",81); put("c",194); put("ੀਰ ",33); put("a",561); put("n",492); put("o",398); put("l",256); put("m",260); put("j",16); put("k",37); put("h",252); put("i",537); put("w",71); put("v",42); put("u",236); put("t",467); put("s",328); put("r",400); put("p",124); put("z",13); put("y",106); put("x",19); put("ਿਆ।",22); put("ਾਤਰ",17); put("ਾਤਾ",27); put("ਾਤੀ",12); put("ਿਆਣ",31); put("ਿਆਦ",20); put("ਿਆਨ",47); put("ਿਆਲ",13); put("ਿਆਰ",28); put("ਿਆਵ",14); put("ਿਆਸ",12); put("ਾਣਕ",12); put("ਾਣੂ",104); put("ਿਆਂ",76); put("ਾਣੀ",40); put("ਾਣਿ",27); put("ਾਣਾ",22); put("ਾਨੇ",13); put("ਾਨਾ",31); put("ਿਊਟ",14); put("ਾਨੀ",48); put("੩੧ ",18); put(" । ",128); put("੩੦ ",23); put("ਾਦੀ",22); put("ਾਦਾ",19); put("ਾਨਕ",26); put("ੁਝ ",21); put("।ਇਸ",14); put("ium",27); put("is ",22); put("ion",36); put("ੀਤ ",15); put("਼੍ਰ",22); put("੦੦੮",24); put("ੀਪ ",375); put("ੀਨ ",57); put("ੀਮ ",51); put("ਟੀ ",57); put("ਜੋਂ",19); put("ਾਗਰ",20); put("ਾਕੀ",370); put("ਾਕਿ",34); put("ਟਾ ",22); put("੨੩ ",13); put(" m",24); put(" o",57); put(" h",17); put(" i",57); put(" d",21); put(" e",15); put(" f",30); put(" a",133); put(" b",21); put(" c",34); put(" t",120); put(" w",40); put(" p",41); put(" s",54); put("੨੨ ",14); put(" r",16); put("੨੧ ",14); put("੨੫ ",14); put("਼ਸੀ",29); put(" H",25); put(" I",54); put(" N",32); put(" O",31); put(" L",21); put(" M",43); put("੨੪ ",13); put(" B",32); put(" C",54); put(" A",46); put(" F",17); put(" G",21); put(" D",15); put(" E",17); put("ਿਰ ",73); put(" S",47); put(" R",22); put("਼ਹਿ",50); put(" P",44); put(" W",15); put(" T",36); put("ਜੀਵ",20); put("੨੭ ",13); put("੨੬ ",13); put("ਿਲ ",25); put("ਜੁਲ",54); put("ਜਿੰ",30); put("੨੯ ",16); put("ਜੂਨ",35); put("਼ਾਂ",36); put("਼ਾਹ",32); put("੨੮ ",15); put("਼ਿਆ",14); put("ੀਕ ",34); put("ਜ਼ਮ",12); put("਼ਿਲ",75); put("ਜ਼ਾ",33); put("ਜ਼ਿ",88); put("ਾਂਦ",190); put("ਜਾਂ",231); put("ਜ਼ੀ",72); put("ਾਂਤ",20); put("ਾਂਸ",16); put("ਜਾਬ",125); put("਼ੁਰ",27); put("ਜਾਤ",13); put("ਜਾਣ",55); put("ਜਾਦ",21); put("ਜਿਮ",22); put("ਜਿਲ",12); put("ਜੀਅ",19); put("ਿਸ ",72); put("ਾਅਦ",30); put("ਜਿਸ",70); put("ਜਿਹ",19); put("ਾਇਆ",59); put("ਾਇਣ",62); put("੨੦ ",14); put("ਾਇਲ",17); put("ਟਰ ",67); put("ਾਈਟ",14); put("ਾਈਡ",27); put("ਾਉਂ",14); put("ਾਈਨ",29); put("ਾਉਣ",23); put("਼ਬਦ",26); put("ੀਂ ",52); put("ਿਤ ",82); put("ਟਨ ",17); put("ਚੰਦ",21); put("੧੮ ",12); put("ਛੋਟ",13); put("੧੯ ",14); put("ੀਆ ",53); put("ਿਨ ",1101); put("਼ਰਵ",39); put("ਜਨਮ",32); put("ਜਨਵ",39); put("ਜਨਸ",13); put("ਜਦੋ",15); put("ਜਧਾ",12); put("ਿਬ ",69); put("ੀਤਾ",41); put("Co",14); put("ੀਤੀ",42); put("ੁਆਰ",46); put(" In",28); put(" Ma",13); put("he ",69); put("ਾੜੀ",12); put("ੀਟਰ",38); put("Ma",13); put("Ol",12); put(" Co",14); put("In",29); put("L ",13); put("।",1840); put("ੀਕਲ",22); put("ੂਪ ",25); put("ੀਕਨ",13); put("ਿਲੀ",21); put("ਿਲਾ",83); put("Th",15); put("ਿਲ੍",13); put("ਿਲੋ",46); put("ਿਲੇ",38); put("ੂਨ ",35); put("ਿਲਦ",12); put("ਵ",3164); put("ਲ",4004); put("ਰ",5772); put("ਿ",5178); put("ਾ",10004); put("਼",1111); put("ਹ",4455); put("ਸ",5034); put("ਦ",5926); put("ਧ",297); put("ਤ",3377); put("ਥ",271); put("ਢ",42); put("ਣ",777); put("ਠ",69); put("ਡ",853); put("ਮ",2207); put("ਯ",188); put("ਬ",2031); put("ਭ",430); put("ਪ",1926); put("ਫ",303); put("ਨ",4410); put("ਕ",3798); put("ਗ",2047); put("ਖ",660); put("ਐ",62); put("ਓ",66); put("ਝ",61); put("ਜ",2041); put("ਟ",625); put("ਘ",134); put("ਛ",70); put("ਚ",1522); put("ਅ",1321); put("ਆ",1270); put("ਇ",2053); put("ਂ",2880); put("ਏ",233); put("ਈ",490); put("ਉ",422); put("ਊ",48); put("ੱ",1924); put("ੰ",2555); put(" a ",18); put("੦",200); put("੧",273); put("੪",62); put("ਿਮਨ",20); put("੫",77); put("੨",239); put("੩",93); put("੮",92); put("੯",96); put("੬",69); put("੭",58); put("੨੦੦",38); put("ੜ",191); put("ੀ",4636); put("ੁ",1825); put("ੂ",1115); put("ੇ",3761); put("ੈ",2081); put("ੋ",1676); put("ੌ",206); put("੍",1046); put("ੂਲ ",22); put("ੀਜਿ",21); put(" Ol",12); put("ੂਰ ",25); put("b ",18); put("ਿਹਾ",91); put("a ",87); put("ਿਸੇ",29); put("ਿਸ਼",57); put("ਿਸਾ",23); put(" Th",15); put("ਿਸਤ",34); put("ਚੌਂ",12); put("ਚੋਂ",38); put("ਿਵੇ",63); put("ਿਵਾ",13); put("ੀਕਾ",45); put("i ",27); put("ਿਟੀ",38); put("ge",13); put(" in",40); put("ic ",12); put("fi",14); put(" is",12); put("fo",16); put("ਚਾਈ",23); put("he",95); put("ha",27); put("gh",19); put("go",13); put("g ",34); put("ea",30); put("ਚਾਰ",34); put("ec",17); put("ਚਾਲ",16); put("ed",45); put("de",37); put("di",36); put("ia ",20); put("ev",13); put("h ",33); put("Ind",16); put("ee",14); put("el",41); put("ei",12); put("en",68); put("em",14); put("et",19); put("ੀਆਂ",178); put("es",53); put("er",114); put("ੀਅਤ",34); put("ca",15); put("e ",169); put("ਚੀਨ",33); put("be",16); put("da",20); put("f ",44); put(" of",43); put("ct",18); put("cs",14); put("co",29); put("ck",12); put("ch",22); put("ce",32); put("c ",16); put("ics",14); put("d ",98); put("at",58); put("as",29); put("ar",52); put("al",54); put("ai",16); put("am",68); put("an",97); put("ac",18); put("ad",16); put("ab",12); put("ਿਨਾ",26); put("nt",47); put("ns",26); put(" am",51); put(" an",24); put("ਿਨੇ",13); put("ੈ। ",755); put("of",44); put("om",42); put("on",91); put("ol",28); put(" ਅ",1094); put("os",19); put(" ਇ",1749); put(" ਆ",274); put("ou",18); put("or",54); put(" ਏ",119); put("r ",72); put(" ਉ",313); put("ow",13); put(" ਈ",30); put(" ਕ",1460); put("pe",18); put(" ਖ",182); put(" ਗ",918); put("ਿਨ੍",12); put(" ਐ",59); put(" ਓ",47); put(" ਜ",1208); put(" ਝ",16); put(" ਟ",112); put("po",12); put(" ਘ",42); put("pi",19); put(" ਚ",259); put(" ਛ",39); put("lo",16); put("ਜੋ ",82); put("ll",20); put("igh",12); put("ly",15); put("o ",26); put("ma",17); put("mb",17); put("me",42); put("mi",19); put("mp",27); put("mu",48); put("na",37); put("nc",21); put("nd",68); put("ne",28); put("ng",50); put("ni",32); put("ਿਤਾ",77); put("ਿਤੀ",12); put(" ।",190); put("ੀਅਮ",40); put("m ",58); put("ੀਅਨ",27); put("ਿਥਿ",27); put("ine",16); put("ing",33); put("li",35); put("le",33); put("ld",21); put("la",31); put("n ",137); put(" co",22); put("ht",18); put("hu",17); put("hi",29); put("ho",16); put("id",13); put("ic",60); put("ia",36); put("ig",20); put("in ",38); put("ie",22); put("k ",17); put("ir",14); put("is",39); put("it",46); put("iu",27); put("il",21); put("in",129); put("io",41); put("l ",48); put("ਾਰਕ",16); put("ਾਰਚ",41); put("ਾਰਤ",101); put("ਾਰਨ",27); put("wo",13); put("ਾਮਿ",15); put("y ",61); put("wa",12); put("ve",29); put("ਾਰੀ",54); put("ur",21); put("us",14); put("ਾਰਾ",51); put("ut",16); put("um",56); put("un",15); put("ty",14); put("ਾਰੇ",39); put("ua",16); put("to",25); put("ts",12); put("tr",30); put("te",65); put("ti",67); put("ਾਬਕ",377); put("th",116); put("ta",28); put("st",52); put("se",26); put("sh",12); put("si",30); put(" ੨",195); put(" ੩",56); put(" ੪",26); put(" ੫",29); put("u ",55); put("ਚਰਲ",20); put(" ੬",17); put(" ੭",14); put(" ੮",15); put(" ੯",19); put("rs",22); put("rt",24); put("ry",21); put(" ੧",210); put("ro",42); put("ri",64); put("ਚਲਾ",12); put("re",47); put("rd",17); put("ੁਤ ",26); put("ra",24); put("t ",72); put(" ਹ",2872); put(" ਸ",2699); put(" ਵ",2408); put("ਾਬਲ",23); put("ht ",12); put(" ਰ",498); put(" ਲ",715); put(" ਬ",868); put(" ਭ",339); put("s ",155); put("ੁਣ ",18); put(" ਮ",1134); put(" ਯ",133); put(" ਨ",1023); put(" ਪ",1056); put(" ਫ",184); put(" ਤ",951); put(" ਥ",21); put("ਜੇ ",27); put(" ਦ",4245); put(" ਧ",86); put(" ਡ",55); put("ਾਬੀ",48); put(" ਢ",16); put("pr",12); put("ਾਬਾ",23); put("ਿਗਿ",35); put("ੁਰ ",13); put(" s ",16); put("ਾਹੀ",40); put("ਾਹਿ",88); put("ਿਚਾ",17); put("hum",14); put("ਾਸਿ",34); put("ਾਸ਼",82); put("ਾਸੇ",16); put("ਜਾ ",63); put("ਚਨਾ",19); put("ਾਲੇ",56); put("ਾਲਾ",46); put("ਾਲੀ",54); put("ਜ਼ ",52); put("ਜੀ ",155); put("ਿਖੇ",23); put("ਾਵਾ",47); put("ਿਖਾ",19); put("ਾਵਲ",13); put("ਿਕਾ",29); put(" th",90); put("ym",13); put("ਿਕਸ",14); put("ਹਾਂ",94); put("ਹੀਰ",14); put("ਹੀਨ",13); put("ਹੁਣ",12); put("ਹੁਤ",24); put("ਹਿਰ",60); put("ਹਿਲ",50); put("ਹਿਨ",24); put("ਹਿਬ",75); put("ਹਿਸ",19); put("ਹਾਲ",13); put("ਹਾਰ",25); put("ਹਾਨ",18); put("ਹਿਤ",27); put("ਹੀਂ",44); put("ਹਾਸ",57); put("ਹਾਈ",26); put("ਜਨ ",22); put("਼ਨ ",23); put("ਹਰਿ",36); put("ਹਨਾ",25); put("er ",48); put("es ",28); put("ਸ੍ਰ",19); put("ers",16); put("en ",20); put("ਸਿੱ",77); put("ਸਿੰ",78); put("ਸੂਰ",32); put("ਸੂਬ",12); put("ਸਿਧ",13); put("ਸਿਰ",19); put("ਹਨ।",438); put("ent",21); put("ght",14); put("ਸੀ।",71); put("ਸ਼ਨ",37); put("ਸ਼ਤ",17); put("ਸ਼ਰ",12); put("ਸ਼ਬ",26); put("ਸ਼ਹ",65); put("ਸ਼ੁ",34); put("ਸ਼ੀ",30); put("ਸਾਂ",13); put("ਸ਼ਿ",19); put("ਸ਼ਾ",149); put("ਸ਼ਖ",29); put("ਸ਼ਟ",21); put("ਸਾਨ",18); put("ਸਾਰ",46); put("ਸਿਕ",33); put("ਸਿਖ",14); put("ਸਾਲ",1144); put("ਸਾਹ",90); put("ਸਿਟ",36); put("ਸੀਅ",29); put("ਸਾਇ",73); put("ਸ਼ੇ",16); put("ਸ਼੍",23); put("ਸਿਆ",13); put("ਸਰਕ",13); put("ਸਮੇ",23); put("ਸਮਾ",24); put("ਗੜ੍",19); put("ਸਰੀ",12); put("ਸਲਾ",21); put("ਸਤੰ",39); put("ਸਦੇ",13); put("ਸਦਾ",17); put("ਸਦੀ",15); put("ਸਨੂ",15); put("ਗੁਰ",167); put("ਗੋਬ",26); put("for",13); put("ਸਟਾ",14); put("ਗ੍ਰ",502); put("ਸਨ।",37); put("ਚਾ ",12); put("ਸਤਾ",54); put("ਸਥਾ",37); put("ਸਥਿ",13); put("ਗਰੇ",16); put("ਗਰਾ",30); put("ਗਰੀ",415); put("ਿਚ ",162); put("ਾਹ ",17); put("ਾਸ ",54); put("਼ਟਰ",18); put("ਿਕ ",134); put("ਕੰਪ",19); put("ਾਲ ",1369); put("੧੬ ",14); put("cti",12); put("ਗਸਤ",63); put("੧੭ ",15); put("ਾਰ ",238); put("੧੪ ",14); put("੧੫ ",13); put("੧੧ ",12); put("ਾਮ ",62); put("ਗਿਆ",104); put("੧੨ ",16); put("ਗਾਂ",14); put("੧੩ ",12); put("਼ਖ਼",29); put("ਾਬ ",99); put("੧੦ ",14); put("ਹੱਦ",12); put("ਖਾਂ",21); put("ਖ਼ਸ",29); put("ਖਿਆ",40); put("ਾਨ ",155); put("com",13); put("ਗਣਿ",17); put("ਿਆ ",232); put("ਾਦ ",29); put("੦੮ ",24); put("cs ",14); put("ਾਣ ",28); put("ਾਤ ",23); put("ਖੇਡ",37); put("ਖੇਤ",37); put("ਾਜ ",52); put("ਖੋਂ",14); put("ed ",32); put("ਕੌਮ",15); put("ਾਗ ",23); put("ਕ੍ਰ",37); put("ਸੰਸ",37); put("੦੦ ",21); put("ਘਰ ",13); put("ਾਈ ",117); put("ਸੰਖ",18); put("ਕਾਂ",22); put("ਸੰਬ",52); put("ਸੰਤ",12); put("ਕਿਤ",57); put("ਾਂ ",1353); put("਼ੀ ",81); put("ਹੋਏ",48); put("ਹੋਇ",70); put("ਹੋਈ",20); put("ਕਾਲ",30); put("ਕਾਸ",23); put("ਕਾਬ",25); put("ਕਾਰ",103); put("ਕੀਤ",87); put("ਹੋਰ",25); put("ਹੋਣ",23); put("ਕਿਲ",58); put("ਕਿਸ",74); put("ਕਿਹ",19); put("ਕੁਝ",20); put("ਕੁੱ",13); put("dia",15); put("਼ਾ ",51); put("ਹਿੰ",31); put("ਹੈ।",922); put("ਕੇਸ",12); put("ਹੁੰ",468); put("ਕੋਈ",24); put(" ਅਪ",47); put(" ਅਨ",20); put(" ਆਉ",20); put(" ਅਧ",17); put("ੱਖੀ",14); put("ੱਖਾ",16); put(" ਅਮ",64); put(" ਅਰ",39); put(" ਅਸ",17); put("ੱਖਰ",18); put("ਕਦੀ",15); put(" ਅਜ",33); put(" ਅਗ",67); put(" ਅਕ",54); put(" ਅਤ",411); put("ੰਸਥ",15); put("ਗਾ ",22); put("ਕਨੀ",13); put("ੰਸਾ",14); put("re ",16); put("ੱਚੋ",29); put("ੱਛਮ",12); put("ਕਤੀ",13); put("ਕਤੂ",34); put("ੱਜੋ",16); put("rs ",13); put(" ਉੱ",56); put(" ਉਹ",51); put(" ਉਸ",69); put(" ਇੱ",255); put(" ਇੰ",25); put(" ਉਪ",25); put(" ਉਨ",48); put(" ਉਤ",19); put(" ਏ।",18); put(" ਇਹ",533); put(" ਇਸ",723); put(" ਇਲ",20); put(" ਅੰ",217); put(" ਅੱ",34); put("ਾ। ",18); put(" ਇਨ",39); put(" ਇਤ",23); put(" ਇਥ",21); put("rig",16); put("ਗਰ ",22); put(" ਆਮ",22); put("ੱਖਣ",15); put(" ਆਰ",19); put(" ਇਕ",94); put(" ਆਦ",14); put(" ਆਪ",76); put(" ਆਬ",12); put("ਸਟ ",13); put(" ਕਰ",183); put(" ੨ ",19); put(" ਕਲ",399); put(" ਕਹ",19); put(" ਕਾ",86); put(" ਕੀ",109); put(" ਕਿ",260); put(" ਕੁ",68); put(" ਗਈ",32); put(" ਕੇ",73); put(" ਕੈ",22); put(" ਕੋ",64); put(" ਕੌ",24); put(" ੩ ",14); put(" ਕ੍",23); put(" ਗਏ",21); put("ਕਸ਼",26); put(" ਓਲ",31); put(" ਕਈ",21); put(" ੧ ",21); put("ry ",17); put("ਸਤ ",69); put("ਕਲਾ",14); put("ਵਰਗ",12); put("ਕਲੰ",379); put(" ਏਫ",13); put(" ਏਨ",15); put(" ਏਸ",15); put("ਵਰਸ",36); put(" ਐਗ",22); put(" ਏਲ",14); put("ਵਰਤ",32); put("ਵਰੀ",76); put(" ਜ਼",109); put(" ਜਿ",159); put(" ਜਾ",364); put(" ਜੁ",64); put(" ਜੀ",148); put(" ਜੂ",37); put(" ਜੇ",15); put(" ਜੋ",96); put(" ਜੰ",39); put("ਸਨ ",38); put("ਕਰਕ",17); put(" ੮ ",14); put("ਕਰਦ",41); put("ੱਡਾ",23); put("ਕਰਨ",55); put(" ਚਿ",16); put(" ਚਾ",51); put(" ਚੁ",16); put(" ਚੀ",38); put(" ਚੰ",37); put(" ਚੱ",12); put(" ਜਰ",13); put(" ਛੋ",14); put("ਕਰੀ",18); put(" ੯ ",15); put("ਕਰੋ",16); put(" ਜਨ",89); put(" ਜਦ",19); put("ਕਲਚ",23); put(" ੬ ",12); put("ੱਤਰ",42); put(" ਚਲ",15); put(" ੭ ",13); put("ਗੀ ",17); put("ਸਭ ",25); put(" ਗਰ",23); put(" ਕੰ",44); put(" ੪ ",15); put(" ਖੇ",84); put(" ਗਣ",16); put(" ਖਾ",28); put(" ਖਿ",13); put("ੱਥੇ",12); put(" ਖ਼",15); put("ੱਤਾ",19); put(" ਘਰ",13); put(" ਗ੍",436); put(" ੫ ",15); put(" ਗੋ",35); put(" ਗੁ",188); put(" ਗਿ",86); put("ੱਤੇ",24); put(" ਤਰ",31); put("ੰਖਿ",16); put(" ਤਾ",41); put(" ਤਿ",24); put("ੰਗਾ",15); put("ੰਗਰ",20); put(" ਤਕ",27); put(" ਤੱ",66); put(" ਦਰ",56); put(" ਦੂ",37); put(" ਦਾ",950); put(" ਦਿ",1171); put(" ਦੀ",419); put(" ਦੁ",51); put(" ਦਸ",54); put(" ਤੌ",38); put(" ਤੋ",497); put(" ਤੇ",160); put(" ਟੀ",56); put(" ਟਰ",13); put("ੰਗ੍",60); put(" ਮਈ",37); put(" ਬੇ",15); put(" ਬੋ",36); put(" ਬਾ",492); put(" ਬਿ",25); put(" ਬੀ",32); put(" ਬੁ",18); put(" ਭਗ",25); put(" ਬਹ",34); put(" ਫ੍",14); put(" ਪੱ",30); put(" ਪੰ",163); put(" ਬਲ",14); put(" ਬਰ",25); put(" ਬਨ",14); put(" ਫ਼",66); put(" ਪੜ",16); put(" ਫਾ",12); put(" ਫਿ",18); put(" ਫੁ",20); put(" ਬਣ",71); put(" ਪੋ",18); put(" ਪ੍",133); put(" ਮੌ",17); put(" ਮੋ",24); put(" ਮੈ",37); put(" ਮੀ",19); put(" ਮੁ",481); put(" ਮਾ",131); put(" ਮਿ",97); put(" ਮਹ",95); put(" ਮਸ",25); put(" ਬੰ",15); put("st ",12); put(" ਭੌ",12); put(" ਮਨ",31); put(" ਮਤ",12); put(" ਭਾ",230); put(" ਭੀ",16); put(" ਬ੍",13); put(" ਭਰ",19); put(" ਨਹ",38); put(" ਨਿ",106); put(" ਨਾ",302); put(" ਨੂ",313); put(" ਨੇ",127); put(" ਦੱ",14); put(" ਨਵ",51); put("ਗਏ ",15); put(" ਦੇ",1425); put(" ਦੋ",31); put(" ਧਰ",56); put(" ਪੁ",69); put(" ਪੀ",18); put(" ਪਿ",76); put(" ਪਾ",125); put(" ਪੈ",40); put(" ਪੇ",13); put(" ਪੂ",34); put(" ਪਰ",200); put(" ਪਹ",57); put(" ਪਟ",13); put("ਕੋ ",15); put(" ਲੱ",19); put("ਈ ",351); put("ੰਦੇ",65); put(" ਵਖ",19); put("ੰਦੀ",31); put("ੰਦਾ",409); put(" ਵਰ",63); put(" ਵਧ",14); put(" ਵੀ",103); put(" ਵਿ",1204); put(" ਵਾ",793); put("ੰਦਰ",40); put(" ਵਸ",13); put(" ਵੇ",12); put(" ਵੈ",16); put(" ਵੰ",18); put(" ਵੱ",108); put(" ਸਕ",45); put("ੰਬਰ",125); put(" ਯਾ",23); put(" ਰਚ",14); put(" ਯੂ",72); put("ਖੇ ",23); put(" ਮੰ",56); put(" ਰਾ",142); put(" ਰਿ",33); put(" ਰਸ",75); put(" ਰਹ",56); put(" ਰੇ",12); put(" ਲਈ",76); put(" ਰੁ",23); put("str",14); put("ੰਪਿ",40); put(" ਰੂ",37); put(" ਰੋ",38); put(" ਲਗ",21); put(" ਰੱ",19); put(" ਲਾ",29); put(" ਲਿ",55); put(" ਲੀ",380); put("ਏ ",114); put(" ਲੇ",15); put(" ਲੈ",20); put(" ਲੋ",37); put("Oly",12); put("ਗਤ ",30); put("ਲੰਪ",29); put("ਲੰਡ",379); put("ਲੱਗ",14); put("ਂ ",2409); put("ੰਜੀ",16); put("ੰਜਾ",127); put(" ਸਭ",32); put(" ਸਬ",19); put(" ਸਮ",69); put(" ਸਨ",75); put(" ਸਪ",16); put(" ਸਰ",55); put(" ਸਟ",13); put(" ਸਤ",61); put(" ਸਥ",20); put(" ਸਦ",12); put("ੰਤਰ",46); put(" ਹਰ",55); put(" ਸ੍",21); put(" ਸੋ",27); put("ਅ ",12); put(" ਸਾ",1296); put(" ਸਿ",210); put(" ਸ਼",257); put("ਖੀ ",31); put(" ਹਨ",519); put(" ਸੇ",33); put(" ਸੂ",56); put(" ਸੀ",135); put(" ਸੁ",40); put(" ਹੋ",233); put("ੰਡਲ",14); put("ੰਡੀ",26); put(" ਸੱ",24); put("ਆ ",416); put(" ਸੰ",107); put("ੰਡਾ",15); put(" ਹਾ",41); put(" ਹਿ",46); put(" ਹੀ",66); put(" ਹੁ",491); put(" ਹੇ",15); put(" ਹੈ",1352); put("ੰਡਰ",381); put("ਟ ",103); put("ਝ ",29); put(" ਏ ",29); put("ਜ ",145); put("ਕਸ ",17); put("ਚ ",1074); put("ਘ ",72); put("ਹਿ ",31); put("ਗ ",162); put(" ਚ ",20); put("ਹਾ ",59); put("ਖ ",140); put("ਕ ",1139); put("ਹੀ ",112); put("ਓ ",12); put("ੀ। ",55); put("pic",12); put("ਕਰ ",44); put("ਵੰਡ",19); put("ਰ ",1488); put("ਵੱਖ",25); put("ਹੇ ",27); put("ਵੰਬ",36); put("ਵੱਜ",17); put("ਵੱਡ",34); put("ਭ ",31); put("ਹੈ ",423); put("ਵੱਲ",20); put("ਸਕਦ",19); put("ਗਈ ",25); put("ਮ ",350); put("ਫ ",31); put("ਕੇ ",100); put("ਬ ",211); put("ਓਲੰ",29); put("ਪ ",461); put("ਧ ",64); put("ਨ ",1907); put("ਥ ",48); put("ਕਾ ",68); put("ਦ ",171); put("ਕਿ ",66); put("ਣ ",217); put("ਕੀ ",396); put("ਹੋ ",30); put("ਤ ",537); put("ਠ ",22); put("ਡ ",132); put("ਖਣ ",24); put("ਾ ",2802); put("ਵਿਸ",21); put("ਵਾਰ",49); put("ਵਿਕ",13); put("ੁ ",14); put("ਵਾਲ",96); put("ਵਾਸ",13); put("ਵਿਗ",34); put("ਵਿਖ",22); put("ਵਿਚ",200); put("ੀ ",2902); put("ਵਿਦ",16); put("ਿ ",127); put("ਵਾਨ",14); put("ਵਾਂ",742); put("ਹ ",633); put("ਸਰ ",20); put("਼ ",152); put("ਵ ",71); put("ਸਾ ",23); put("ਵੇਦ",48); put("ਸ ",997); put("ਵੇਂ",22); put("ਸ਼ ",84); put("ਲ ",1735); put("ਸਸ ",13); put("ਵਿੱ",870); put("ਸੇ ",56); put("ਹਨ ",79); put("ਂ।",15); put("ਕਨ ",15); put("ੋ ",213); put("ਸੀ ",89); put("੍ ",22); put("ਹਰ ",16); put("ੇ ",2940); put("ੈ ",444); put("ੂ ",303); put("ਕਟ ",14); put("ਰਸ਼",34); put("ਰਸਾ",69); put("ਰਸਿ",50); put("ਰਹਿ",56); put("ng ",24); put("ਰਹੇ",17); put("nce",16); put("ne ",14); put("ndi",15); put("ਰਾਂ",87); put("ਰਾਜ",89); put("ਰਾਬ",13); put("ਰਾਨ",31); put("ਰਿਆ",72); put("ਰਾਣ",19); put("ਰਾਸ",25); put("ਰਾਹ",24); put("ਰਿਕ",21); put("ਰਾਵ",14); put("ਰਾਮ",35); put("nd ",32); put("ਰਿਤ",27); put("ਰੀਆ",20); put("ਰਮਾ",139); put("ਮੰਡ",22); put("ਮੰਨ",14); put("ਲੇ ",121); put("ਰਵਾ",29); put("ਰਵਰ",37); put("ਰੈਲ",39); put("ਰੋਜ",15); put("ਰੋਮ",30); put("ਰੋੜ",12); put("nte",17); put("ੰਕ ",58); put("ns ",12); put("ਰੀਸ",12); put("ਰੀਬ",18); put("ਰੀਕ",94); put("ਰਿਸ",18); put("ਰਿਹ",15); put("ੰਗ ",69); put("। ",1125); put("ਕਈ ",21); put("ਰੂਪ",26); put("ੰਘ ",71); put("ਰੈਗ",367); put("ਰੈਕ",12); put("ਰੇਗ",15); put("ਰੇਜ",79); put("ੰਜ ",22); put("ਲਮ ",13); put("ਰਕੇ",20); put("of ",41); put("ਲਣ ",22); put("ਰਕਾ",23); put("ਐਗਰ",22); put("ਰਨਾ",16); put("ਲਾ ",163); put("ਰਦੁ",28); put("ਰਦੀ",16); put("ਰਦਾ",42); put("ਰਦੇ",29); put("ਰਮਨ",15); put(" ਈ ",16); put("ਰਬੀ",20); put("ਲੀ ",116); put("ਯੋਗ",18); put(" ਆ ",21); put("on ",41); put("ਰਤਾ",15); put("ਰਤਿ",15); put("ਰਤੀ",63); put("ona",13); put("ons",12); put("ਯੂਨ",34); put("ਯੂਰ",14); put("ਯੂਲ",19); put("ਲੀਪ",371); put("ੱਤ ",62); put("ਲੀਵ",25); put("ੱਦ ",13); put("ਲਾਂ",56); put("ਲਾਈ",52); put("ਵਲ ",18); put("ਲਿਆ",33); put("ਲੀਅ",22); put("ld ",18); put("ਲੀਆ",17); put("ਲਾਵ",16); put("ਲਿਖ",25); put("ੱਧ ",29); put("ਵੇ ",16); put("ਲ੍ਹ",16); put("ੱਲ ",23); put("ਵਾ ",26); put("ਲੋਮ",22); put("ਲੋਂ",20); put("ਲੋਕ",25); put("ਲੋਗ",23); put("ਵੀ ",125); put("ਲੇਖ",15); put("ਲੈਂ",19); put("ੰਤ ",18); put("mb ",14); put("ਵਖ ",12); put("ੰਡ ",46); put("ਲਚਰ",23); put("mer",15); put("ਲਗਾ",13); put("ੰਨ ",21); put("lym",12); put("ੰਧ ",16); put("।ਇ",25); put("ੰਦ ",43); put("ੰਥ ",14); put("mpi",14); put("ਰੱਖ",17); put("ੱਕ ",255); put("ਰੰਥ",15); put("ਵਨ ",15); put("ੱਖ ",91); put("mu ",47); put("ੱਚ ",827); put("ਆਉਂ",16); put("ਅਨੁ",13); put("੍ਹਾ",96); put("ਇਸ ",693); put("ਰਾ ",103); put("ਮਨੇ",20); put("ਇਹ ",527); put("ਮਨੁ",16); put("ਮਨੀ",13); put("ਅਤੇ",407); put("ਰਲ ",24); put("ਭਾਈ",15); put("ਭਾਗ",17); put("ਭਾਰ",147); put("ਭਾਵ",14); put("ਭਾਸ",44); put("ਅਜਿ",15); put("ਇਲ ",16); put("ਰਨ ",81); put("ਰਮ ",38); put("ਅਰਥ",18); put("ਅਮਰ",51); put("ਯਾ ",16); put("ਬੋਲ",29); put("ਰਡ ",23); put("ਅਪ੍",39); put("ਰਤ ",82); put("ਬ੍ਰ",15); put("੍ਰੋ",27); put("੍ਰੇ",90); put("੍ਰੈ",416); put("ਰਣ ",20); put("੍ਰਮ",14); put("੍ਰਦ",16); put("੍ਰੀ",65); put("੍ਰਿ",60); put("੍ਰਾ",30); put("੍ਰਸ",16); put("੍ਰਹ",30); put("ਰਥ ",20); put("੍ਰੰ",13); put("ਮੇਂ",24); put("ਆਨੀ",21); put("ਏ। ",23); put("ਆਪਣ",51); put("ਆਦਿ",12); put("ਆਦਾ",18); put("ਆਣਾ",27); put("ਮੈਨ",17); put("ਮਾਨ",46); put("ਮਾਤ",26); put("ਮਾਣ",116); put("ਮਿਕ",21); put("ਮਾਰ",62); put("ਮਾਲ",18); put("ਮਿਥ",28); put("ਮਾਂ",39); put("ਇਆ।",31); put("ਮੁੱ",38); put("ਮਿਲ",41); put("ਮਿਸ",19); put("ਮੀਟ",34); put("ਮੁਖ",14); put("ਮੁਕ",29); put("ਮੁਤ",380); put("ਰੋ ",14); put("ਮਹਾ",43); put("ਮਹਿ",32); put("ਮਹੀ",13); put("ਆਵਾ",13); put("ਰੂ ",145); put("ਭੌਤ",12); put("ਆਰਾ",46); put("ਰੀ ",651); put("ਬੰਧ",25); put("ਰੇ ",75); put("ਲਈ ",78); put("ਉਣ ",23); put("ਮਰੀ",43); put("ਇਥੇ",16); put("ਬਣਾ",43); put("ਇਨ੍",18); put("ਪੜ੍",12); put("ਫੁਟ",13); put("ਫ਼ਰ",40); put("ਇਣਕ",56); put("ਉਸ ",51); put("ਉਹ ",40); put("ਈਆਂ",13); put("ਇਤਿ",19); put("ਮਨ ",35); put("ਇਸਦ",16); put("ਪ੍ਰ",176); put("ਪੈਦ",15); put("ਅੰਤ",31); put("ਅੰਦ",15); put("ਅੰਗ",91); put("ਅੰਕ",65); put("ਭੀ ",15); put("ਇਲਾ",16); put("ਈਨਾ",22); put("ਰਜ ",32); put("ਰਚ ",44); put("ਬੀਜ",26); put("ਰਗ ",14); put("ਬਿੰ",25); put("ਬਾਦ",22); put("ਬਾਰ",32); put("ਬਾਬ",12); put("ਰਕ ",18); put("ਬਾਕ",372); put("ਬਾਲ",27); put("ymp",12); put("ਈਡਰ",15); put("ਬਾਅ",27); put("ਬਾਈ",14); put("ਉਂਦ",22); put("ਬਹੁ",25); put("ਭਗਤ",25); put("ਮੇ ",12); put("ਬਲਾ",20); put("ਪੱਛ",12); put("ਪੰਜ",152); put("ਬਰਾ",15); put("ਫ੍ਰ",14); put("ਮੀ ",18); put("ਮਾ ",32); put("ਸਮ",81); put("ਸਭ",32); put("ਸਬ",22); put("ਸਫ",15); put("ਸਪ",32); put("ਸਨ",101); put("ਸਵ",19); put("ਸਲ",51); put("ਸਰ",94); put("ਾ।",27); put("ਸਟ",58); put("ਸਦ",49); put("ਸਤ",207); put("ਸਥ",50); put("ਸਕ",73); put("ਵੱ",108); put("ਵੰ",62); put("ਵੈ",22); put("ਵੇ",119); put("ਉਨ੍",43); put("ਵਸ",16); put("ਵਿ",1234); put("ਵੀ",154); put("ਵਾ",1015); put("ਵਨ",21); put("ਵਧ",14); put("ਵਰ",201); put("ਵਲ",39); put("ਵਖ",19); put("ਲੰ",416); put("ਲੱ",23); put("ਲੜ",14); put("ੌਰ ",34); put("ਲੋ",133); put("ਲ੍",24); put("ਲੇ",163); put("ਲੈ",43); put("ਲਿ",106); put("ਲਾ",368); put("ਲੁ",15); put("ਲੀ",580); put("ਲਹ",12); put("ਰੱ",21); put("ਰੰ",40); put("ਲਵ",25); put("ਲਬ",13); put("ਲਮ",25); put("ਲਤ",16); put("ਲਣ",25); put("ਲਦ",24); put("ਲਚ",23); put("ਲਕ",25); put("ਲਗ",28); put("ਰੈ",428); put("ਰੋ",128); put("ਰ੍",22); put("ਰੀ",839); put("ਰੁ",36); put("ਰੂ",205); put("ਲਈ",79); put("ਰੇ",213); put("ਰਹ",94); put("ਰਸ",179); put("ਰਿ",221); put("ਰਾ",502); put("ਮੱ",15); put("ਮੰ",60); put("ਰਲ",37); put("ਰਵ",92); put("ੀਤ",114); put("ੁਆ",59); put("ੀਦ",20); put("ੀਬ",34); put("ੀਮ",70); put("ੀਨ",92); put("ੀਪ",396); put("ੁਖ",20); put("ੀਵ",67); put("ੁਕ",56); put("ੀਰ",67); put("ੀਲ",39); put("ੇ।",14); put("ੁਝ",24); put("ੁਟ",25); put("ੀਸ",29); put("ੁਜ",22); put("ੀਆ",241); put("ਿਥ",45); put("ਿਦ",23); put("ਿਣ",20); put("ੀਅ",117); put("ਿਤ",204); put("ੀਂ",64); put("ਿਡ",14); put("ਿਟ",58); put("ਿਮ",51); put("ਿਬ",77); put("ਬਰ ",175); put("ਿਪ",16); put("ਿਧ",20); put("ਿਨ",1162); put("ੀਗ",18); put("ਿਵ",98); put("ੀਕ",136); put("ਿਲ",265); put("ਿਰ",130); put("ੀਟ",47); put("ਾੜ",27); put("ੀਜ",44); put("ਿਹ",111); put("ਿਸ",263); put("ਾਡ",16); put("ਇੰਟ",13); put("ਾਣ",249); put("ਿਅ",43); put("ਾਤ",101); put("ਿਆ",517); put("ਾਦ",96); put("ਾਧ",15); put("ਿਉ",16); put("ਾਨ",318); put("ਿਊ",33); put("ਾਪ",44); put("ਾਬ",594); put("ਾਮ",104); put("ਾਰ",660); put("ਾਲ",1569); put("ਾਵ",109); put("ਿਖ",72); put("ਿਕ",215); put("ਿਗ",45); put("ਾਹ",169); put("ਿਚ",202); put("ਾਸ",245); put("ਿਜ",25); put("਼ਾ",203); put("਼ਿ",116); put("ਾਅ",32); put("਼ੀ",109); put("ਾਂ",1630); put("਼ੁ",43); put("ਾਈ",221); put("ਾਉ",53); put("਼ੇ",19); put("ਾਇ",185); put("਼ੋ",16); put("਼ੈ",21); put("ਬਲ ",16); put("਼੍",25); put("ਾਕ",443); put("ਾਗ",63); put("ਾਖ",18); put("ਾਜ",126); put("ਾਚ",13); put("਼ਨ",40); put("਼ਤ",27); put("਼ਟ",24); put("਼ਸ",37); put("਼ਹ",70); put("਼ਵ",12); put("਼ਰ",65); put("਼ਬ",33); put("਼ਮ",21); put("਼ਖ",29); put("ਹੱ",25); put("ਹੰ",15); put("ਹੂ",17); put("ਹੁ",520); put("ਹੈ",1355); put("ਹੇ",48); put("ਹਾ",329); put("ੀ।",87); put("ਹੀ",203); put("ਹਿ",360); put("ਸੰ",167); put("ਸੱ",26); put("ਹੋ",237); put("ਹੌ",13); put("ਸੂ",66); put("ਸੁ",43); put("ਸੀ",222); put("ਸੇ",97); put("ਹਨ",550); put("ਸਹ",12); put("ਸਸ",15); put("ਸਿ",313); put("ਸਾ",1477); put("ਸ਼",623); put("ਹਲ",14); put("ਸੋ",30); put("ਹਰ",67); put("ਹਮ",13); put("ਸ੍",26); put("ਦਸ",57); put("ਦਿ",1225); put("ਦਾ",1748); put("ਦੁ",90); put("ਦੀ",615); put("ਦੂ",48); put("ਥੇ",53); put("ਦਨ",53); put("ਥੋ",13); put("ਦਰ",129); put("ਤੰ",44); put("ਦਲ",21); put("ਤੱ",67); put("ਧਾ",77); put("ਨਜ",12); put("ਨਡ",15); put("ਧੀ",16); put("ਧਿ",28); put("ਨਦ",13); put("ਨਤ",17); put("ਦੇ",1613); put("ਦੋ",54); put("ਨੁਸ",12); put("ਧਰ",65); put("ਨਕ",44); put("ਤਸ",17); put("ਤਵ",19); put("ਤੀ",231); put("ਤੂ",46); put("ਤਿ",96); put("ਤਾ",728); put("ਣੇ",53); put("ਤਨ",20); put("ਤਪ",13); put("ਤਤ",12); put("ਤਰ",186); put("ਤਲ",37); put("ਤਮ",27); put("ਉਹਨ",12); put("ਥੀ",15); put("ਥਿ",46); put("ਥਾ",70); put("ਤੋ",518); put("ਤੇ",631); put("ਨੁੱ",16); put("ਤੌ",43); put("ਇੱਕ",245); put("ਣਕ",72); put("ਨੂੰ",329); put("ਡੇ",30); put("ਣਾ",137); put("ਣੂ",108); put("ਣਿ",62); put("ਣੀ",85); put("ਤਕ",48); put("ਨੇਂ",14); put("ਟ੍",17); put("ਟੇ",26); put("ਨੇਜ",20); put("ਟੀ",130); put("ਟਿ",29); put("ਡਿ",29); put("ਡੀ",68); put("ਨ।",476); put("ਡਾ",86); put("ਡਲ",20); put("ਡਰ",410); put("ਡਦ",12); put("ਮਰ",69); put("ਮਲ",18); put("ਬੰ",44); put("ਮਸ",29); put("ਮਹ",96); put("ਮੁ",499); put("ਮੀ",82); put("ਮਿ",154); put("ਮਾ",391); put("ਮੂ",19); put("ਮੈ",49); put("ਮੇ",59); put("ਮ੍",15); put("ਮੌ",19); put("ਮੋ",28); put("ਰਕ",76); put("ਰਖ",17); put("ਰਗ",45); put("ਰਚ",72); put("ਰਜ",81); put("ਰਟ",18); put("ਯਾ",37); put("ਰਡ",28); put("ਯੂ",73); put("ਰਣ",36); put("ਯੁ",14); put("ਰਥ",37); put("ਰਤ",198); put("ਰਦ",131); put("ਰਨ",116); put("ਰਫ",22); put("ਰਪ",20); put("ਯੋ",27); put("ਰਬ",46); put("ਰਮ",236); put("ਪੰ",164); put("ਬਲ",53); put("ਪੱ",37); put("ਬਰ",215); put("ਫ੍",15); put("ਬਹ",34); put("ਭਗ",29); put("ਬੁ",20); put("ਬੀ",120); put("ਬਿ",55); put("ਬਾ",578); put("ਬੋ",46); put("ਬੈ",14); put("ਬੇ",32); put("ਮਈ",41); put("ਮਕ",17); put("ਬ੍",15); put("ਭਰ",22); put("ਮਜ",12); put("ਮਤ",30); put("ਭਾ",256); put("ਭੀ",18); put("ਭਿ",14); put("ਭੌ",12); put("ਮਦ",18); put("ਮਨ",98); put("ਪਲ",21); put("ਨੰ",12); put("ਪਹ",57); put("ਪਸ",12); put("ਪਰ",222); put("ਪੂ",52); put("ਪੈ",44); put("ਪੇ",23); put("ਪੀ",37); put("ਪੁ",90); put("ਪਾ",168); put("ਪਿ",130); put("ਬਕ",380); put("ਪੋ",22); put("ਪ੍",176); put("ਨ੍ਹ",75); put("ਫਰ",17); put("ਫਲ",16); put("ਬਦ",46); put("ਬਨ",25); put("ਫ਼",106); put("ਪੜ",21); put("ਫਾ",21); put("ਫਿ",21); put("ਫੁ",23); put("ਬਣ",71); put("ਨਵ",102); put("ਦੱ",14); put("ਨਲ",14); put("ਨਰ",14); put("ਨਮ",39); put("ਨੇ",196); put("ਨੂ",341); put("ਨੀ",200); put("ਨੁ",33); put("ਨਾ",539); put("ਨਿ",163); put("ਨਸ",36); put("ਨਹ",40); put("ਨ੍",89); put("ਨੈ",12); put("ਨੋ",19); put("ਪਨ",15); put("ਪਣ",56); put("ਪਤ",28); put("ਪਟ",24); put("ਬਦ ",20); put("ਕਰ",232); put("ਕਮ",20); put("੨ ",59); put("ਕਲ",439); put("ਕਨ",33); put("ਕਦ",33); put("ਕਟ",31); put("ਕਤ",65); put("੧ ",77); put("ਕਈ",21); put("ਕੱ",19); put("ਕੰ",48); put("ਗਲ",25); put("ਗਰ",511); put("੪ ",44); put("ਖੋ",29); put("ਖੇ",111); put("ਗਦ",22); put("ਗਣ",22); put("ਗਤ",41); put("ਖੀ",35); put("ਖਾ",81); put("ਖਿ",54); put("ਖ਼",60); put("ਕੜ",15); put("ਕ੍",37); put("ਗਏ",21); put("ਖਰ",32); put("ਕੌ",24); put("੩ ",43); put("ਕੋ",104); put("ਗਈ",32); put("ਖਦ",15); put("ਕੈ",22); put("ਕੇ",135); put("ਕੁ",80); put("ਕੂ",15); put("ਖਣ",34); put("ਖਤ",12); put("ਕਾ",323); put("ਕਿ",322); put("ਕੀ",517); put("ਕਹ",19); put("ਕਵ",12); put("ਕਸ",64); put("ਏਲ",14); put("ਐਗ",22); put("ਪਹਿ",45); put("ਏਸ",17); put("ਓਲ",31); put("੦ ",87); put("ਜੇ",38); put("ਜੈ",24); put("ਜੋ",120); put("ਜ਼",304); put("ਜਾ",547); put("ਜਿ",213); put("ਜੀ",234); put("ਜੁ",64); put("ਜੂ",46); put("ਪਿਤ",20); put("ੰ ",328); put("ਪਾਸ",19); put("ਪਿਕ",29); put("ਜਦ",23); put("ਪਾਰ",18); put("ਜਧ",12); put("ਜਨ",116); put("ਪਿਊ",14); put("ਪਾਣ",18); put("੯ ",52); put("ਛੋ",17); put("ਚੱ",12); put("ਪਾਕ",32); put("ਚੰ",38); put("ਜਲ",16); put("ਜਰ",27); put("ਟਬ",13); put("ਟਨ",25); put("ਪਾਈ",14); put("ਟਾ",78); put("ਟਰ",121); put("ਜੰ",41); put("ੋਗਰ",27); put("ਗੜ",29); put("੬ ",50); put("ਚਕ",12); put("ਗਸ",65); put("ਗਾ",75); put("ਗੂ",16); put("ਗੁ",197); put("ਗੀ",24); put("ਗਿ",132); put("ਪੂਰ",40); put("ਗੇ",24); put("ਗ੍",505); put("ਗੋ",52); put("੫ ",50); put("ਘਰ",19); put("ਚਿ",28); put("ਚਾ",99); put("ਚੁ",16); put("ਚੀ",48); put("ਚੇ",17); put("ਪਿੰ",41); put("ਪੁਰ",63); put("ਚੋ",42); put("ਚੌ",23); put("੮ ",73); put("ਛਮ",12); put("ਜਗ",13); put("ਚਨ",19); put("ਚਰ",32); put("੭ ",49); put("ਚਲ",24); put("ਅਤ",454); put("ਆਂ",297); put("ਅਜ",34); put("ਅਗ",69); put("ਅਕ",61); put("ਆਣ",33); put("ਇਆ",135); put("ਆਖ",12); put("ਅਸ",23); put("ਅਮ",113); put("ਅਰ",63); put("ਅਲ",18); put("ਅਦ",42); put("ਆਇ",12); put("ਅਧ",17); put("ਆਉ",22); put("ਅਨ",55); put("ਅਪ",47); put("ਪਣੇ",34); put("ਈਆ",13); put("ਇਥ",21); put("ਇਤ",25); put("ਇਣ",62); put("ਆਸ",22); put("ਪਣੀ",15); put("ਆਰ",95); put("ਆਮ",24); put("ਇਕ",101); put("ਆਵ",17); put("ਆਲ",16); put("ਆਨ",54); put("ਆਦ",35); put("ਆਬ",13); put("ਆਪ",78); put("ਆ।",54); put("ਬਾ ",22); put("ਂਕ",18); put("ਂਗ",31); put("ਈ।",12); put("ਂਟ",25); put("ਂਡ",36); put("ਂਸ",30); put("ਂਤ",24); put("ਂਦ",244); put("ਉੱ",56); put("ੋੜ ",16); put("ਬੀ ",78); put("ਏਨ",15); put("ਏਫ",13); put("ਇਨ",48); put("ਅੱ",34); put("ਇਲ",37); put("ਅੰ",220); put("ਈਟ",14); put("ਇਹ",542); put("ਮਈ ",41); put("ਇਸ",741); put("ਉਂ",46); put("ਈਡ",27); put("ਈਨ",32); put("ਏ।",33); put("ਬੇ ",13); put("ਉਦ",21); put("ਉਨ",51); put("ੋਇਆ",71); put("ਉਣ",28); put("ਉਤ",19); put("ਉਪ",26); put("ੜ ",44); put("ਇੱ",255); put("ਇੰ",32); put("ਉਸ",76); put("ਉਹ",56); put("ਊਟ",14); put("ਪਰਮ",113); put("ਨਕਸ",15); put("ਪਤ ",12); put("ਧਰਮ",31); put("ਧਰਤ",22); put("ਪਰ ",49); put("ਧਾਂ",14); put("ਉੱਤ",40); put("ੋਬਿ",25); put("ਦੁਆ",48); put("ਦਿੱ",27); put("ਦੁਨ",24); put("ੋਮੀ",24); put("ਦੂਸ",12); put("ਦੂਜ",16); put("ੋਮਨ",25); put("੦੦",66); put("੦੮",25); put("੧੦",19); put("੧੩",12); put("੧੪",15); put("੧੧",14); put("੧੨",18); put("੧੭",17); put("੧੮",24); put("੧੫",17); put("੧੬",17); put("੧੯",42); put("੨੧",14); put("੨੦",53); put("ਦਾਂ",14); put(" ੧੮",24); put(" ੧੭",16); put("ਦਾਨ",17); put(" ੧੬",17); put(" ੧੫",16); put(" ੧੪",15); put(" ੧੩",12); put(" ੧੨",16); put(" ੧੧",13); put("ੋਲੀ",19); put("ਦਾਰ",26); put(" ੧੯",41); put(" ੨੦",53); put(" ੨੧",14); put("ਦਿਆ",31); put(" ੨੭",12); put(" ੨੬",12); put(" ੨੯",17); put(" ੨੮",14); put(" ੨੩",13); put(" ੨੨",14); put(" ੨੫",13); put(" ੨੪",14); put("ਦਾਸ",19); put(" ੩੦",25); put(" ੩੧",16); put("ਦੀਆ",75); put("ਦਿਨ",1097); put("umb",16); put("੍ਹ ",21); put(" ੧੦",19); put("ਦੋਂ",17); put("੩੧",18); put("੩੦",26); put("um ",31); put("੨੯",17); put("੨੮",15); put("੨੭",13); put("੨੬",13); put("੨੫",14); put("੨੪",14); put("੨੩",13); put("੨੨",14); put("ੱਤ",172); put("ੱਢ",13); put("ੱਡ",45); put("ੱਧ",49); put("ੱਦ",25); put("ੱਥ",25); put("ੱਗ",23); put("ੱਕ",286); put("ੱਖ",185); put("ੱਛ",18); put("ੱਜ",30); put("ੰਸ",52); put("ੱਚ",879); put("ੱਟ",28); put("ੱਠ",21); put("ੱਲ",52); put("ੱਸ",22); put("ੰਥ",18); put("ੰਤ",85); put("ੰਧ",36); put("ੰਦ",618); put("ੰਡ",502); put("ੰਬ",155); put("ੰਮ",32); put("ੰਨ",45); put("ੰਪ",49); put("ੰਕ",75); put("ੰਖ",19); put("ੰਗ",218); put("ਦੇਸ",44); put("ਦੇਵ",25); put("ੰਜ",177); put("ੰਟ",22); put("ੰਘ",85); put("ਨਵਰ",42); put("ਨੀਆ",32); put("ਨੀਅ",13); put("ਨਿਵ",62); put("ਨੀਕ",15); put("ਨਿਆ",24); put("ਬਕ ",378); put("ਨਾਨ",32); put("ਨਾਲ",179); put("ਨਾਵ",16); put("ਨਿਕ",18); put("ਨਾਮ",38); put("ੜ੍",38); put("ਨਾਂ",88); put("ੜੀ",29); put("ੜਾ",29); put("ੜੇ",20); put("ty ",13); put("ਨਸੰ",13); put("ਨਹੀ",36); put("ਏਫ ",13); put("ਨਵੰ",36); put("ੁਦ",13); put("ੂਆ",13); put("ੁਨ",42); put("ੁਤ",412); put("ੁਣ",26); put("ੁਮ",18); put("ੁਰ",279); put("ੁਸ",47); put("ਿੰ",258); put("ੁਲ",97); put("ਿੱ",1026); put("ੈ।",922); put("ੂਜ",17); put("ੂਨ",78); put("ੂਦ",14); put("ੂਰ",124); put("ਏਲ ",13); put("ੂਬ",50); put("ੂਪ",31); put("ੂਸ",23); put("ੂਲ",53); put("ੁੰ",490); put("ੁੱ",117); put("ੂੰ",335); put("ੇਂ",94); put("ੇਕ",12); put("ੇਖ",36); put("ੇਦ",53); put("ੇਤ",52); put("ੇਡ",47); put("ੈਂ",49); put("ੇਟ",14); put("ੇਜ",108); put("ੇਗ",24); put("ੇਰ",47); put("ੇਲ",44); put("ੈਕ",39); put("ੇਵ",52); put("ੈਗ",377); put("ਧਾਰ",30); put("ੇਨ",27); put("ਧਾਨ",15); put("ਧਿਆ",15); put("ੈਣ",13); put("ੈਦ",24); put("ੇਸ",109); put("ੈਟ",17); put("ੈਲ",73); put("ੈਰ",17); put("ੈਨ",38); put("ੈਸ",23); put("ੋਂ",617); put("ੋਇ",77); put("ੋਈ",46); put("tio",34); put("thu",15); put("ੋਟ",27); put("ੌਂ",47); put("ੋਡ",13); put("ੋਜ",32); put("ੋਧ",14); put("ੋਨ",32); put("ੋਪ",22); put("ੋਣ",30); put("ੋਤ",20); put("ੋਏ",51); put("ੋਗ",55); put("ੋਚ",14); put("ੋਕ",33); put("ੌਜ",14); put("ੌਤ",23); put("ੋਮ",61); put("ੋਬ",36); put("ੋਲ",71); put("ੋਰ",92); put("ੋਵ",23); put("ੋਹ",24); put("ੋਸ",21); put("ੋੜ",31); put("ੌਮ",17); put("ੌਰ",50); put("ted",14); put("੍ਹ",146); put("੍ਰ",834); put("ter",25); put("the",71); put("ਆ। ",38); put("ਤੂਬ",34); put("ੇਲ ",13); put("ੇਰ ",12); put("ਤੀਆ",19); put("ੇਸ ",12); put("ਤਿਹ",21); put("ਤਿਆ",30); put("ਤਾਨ",49); put("ਤਿਕ",18); put("ਤਾਬ",383); put("ਨਕ ",14); put("ਤਾਰ",18); put("ਤਾਂ",61); put("ੇਵ ",19); put("ਨਮ ",32); put("ਤੌਂ",25); put("ਤੋਂ",485); put("ੈਨ ",18); put("ਤੌਰ",15); put("ੈਲ ",41); put("ਨਾ ",113); put("ਥਾਂ",13); put("ਥਿਤ",12); put("ਥਿਹ",26); put("ਥਾਨ",18); put("ਦਸੰ",39); put("ਨੀ ",107); put("ੇਗਰ",13); put("ਦਰਿ",26); put("ਨੇ ",143); put("ਤੰਬ",41); put("ਤੱਕ",12); put("ਤੱਤ",53); put("ਂਟ ",12); put("ੇਜੀ",27); put("ੇਜ਼",73); put("ੇਡਾ",24); put("ਂਡ ",22); put("ੈਂਡ",21); put("ੇਡਦ",12); put("ਂਗ ",18); put("ੇਦਨ",48); put("ੇਤੀ",16); put("ੇਤਰ",23); put("ੋਂ ",614); put("ਤੋ ",20); put("ਣਕਾ",14); put("ਤਕਨ",13); put("ਥੇ ",48); put("ਦਨ ",52); put("ੈਕਟ",16); put("ੋਈ ",39); put("ce ",16); put("ੈਗਰ",366); put("ੋਏ ",45); put("ਥਾ ",23); put("ੇਵਾ",19); put("ੇਸ਼",80); put("am ",12); put("ੋਕ ",20); put("al ",27); put("ਣਿਤ",17); put("ਣਿਆ",40); put("and",32); put("amu",47); put("an ",23); put("ੈਦਾ",18); put("ਦਰ ",34); put("ਣਾਇ",20); put("ੌਂ ",41); put("ੋਣ ",17); put("ਦੋ ",25); put("ਤਰਾ",24); put("ਤਰੀ",36); put("ੋਪ ",15); put("ਦੇ ",1528); put("at ",19); put("ਦੀ ",510); put("as ",15); put("ੋਰ ",44); put("ੋਲ ",12); put("ਦਾ ",1619); put("ati",17); put("ਦਿ ",15); put("ੜਾ ",14); put("ੁਟਬ",13); put("ੀਸਟ",12); put("ੀਵਨ",13); put("ੀਵਰ",32); put("ੁਕਾ",27); put("ਤਕ ",19); put("ੜੀ ",26); put("ੀਮਾ",12); put("�",48); put("ੁਰਦ",34); put("ਡਦੀ",12); put("ੜੇ ",18); put("ੁਨਿ",12); put("ੁਨੀ",20); put("ਣੀ ",69); put("ੁਤਾ",380); put("ਣਾ ",86); put("ਡਰਾ",13); put("ਣੂ ",105); put("ਣੇ ",51); put("ਆਂ ",277); put("ੁਸ਼",14); put("ਂਦਰ",14); put("ਂਦੀ",34); put("ਂਦਾ",168); put("ਂਦੇ",20); put("ੈ।ਇ",14); put("ੂੰ ",327); put("ਤਰ ",83); put("ਅਨ ",34); put("ਡਾਂ",31); put("ੁਰੂ",142); put("ੁਰਾ",23); put("ੁਰਸ",21); put("ਿੰਦ",69); put("ਿੰਡ",45); put("ਿੰਘ",68); put("ਿੰਗ",49); put("ਡੀਅ",12); put("ਿੱਤ",44); put("ਿੱਧ",18); put("ਿੱਖ",61); put("ਅਤ ",35); put("ਿੱਚ",863); put("ੁਲਾ",52); put("ੁਲੀ",15); put("ਅਦ ",27); put("ੂਰਜ",24); put("ੂਰਬ",14); put("ੂਬਰ",34); put("ਤਾ ",184); put("ਤੀ ",175); put("ੂਨਿ",14); put("ੂਨੀ",19); put("ਤੇ ",613); put("ਜੰਤ",20); put("ਜੰਗ",15); put("ਡਰ ",388); put("ਆਨ ",22); put("ੂਲੀ",19); put("ਇਆ ",100); put("ਆਪ ",24); put("ਅਮ ",45); put("ੁੱਖ",54); put("ਅਰ ",17); put("ੁੰਦ",474); put("ਡਲ ",18); put("ਟਬਾ",13); put("ਡੀ ",25); put("ਡਾ ",35); put("ਨ। ",77); put("ੇਂ ",52); put("ਡੇ ",21); put("ੜ੍ਹ",37); put("ਟਰੀ",23); put("ਟਾਂ",13); put("ਟਾਇ",14); put("ਅਕਤ",41); put("ਅਕਾ",15); put("ਅਗਸ",63); put("ਆਮ ",19); put("ਆਰ ",21); put("ਣਕ ",58); put("ਟਿਆ",13); put("ਇਕ ",86); put("ਟੀਮ",54); put("ਟ੍ਰ",17); }};
    private static final int[] n_words_s = {112478,136533,89577};
    private static final String name_s = "pa";

    public Profile_pa() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
