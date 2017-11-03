package com.cybozu.labs.langdetect.profiles;

import com.cybozu.labs.langdetect.util.LangProfile;

import java.util.HashMap;

public class Profile_vi extends LangProfile {

    private static final HashMap<String, Integer> freq_s = new HashMap<String, Integer>();
    private static final int[] n_words_s = {13809827,17315344,13396979};
    private static final String name_s = "vi";

    static {
        initialize1();
        initialize2();
    }

    private static final void initialize1() {
    }

    private static final void initialize2() {
    }

    public Profile_vi() {
        this.freq = freq_s;
        this.n_words = n_words_s;
        this.name = name_s;
    }
}
