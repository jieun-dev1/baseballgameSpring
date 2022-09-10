package com.example.BaseballGame.presentation.response;

import com.example.BaseballGame.domain.History;
import java.util.List;

public class Histories {

    private List<History> histories;

    public Histories(List<History> histories) {
        this.histories = histories;
    }

    public List<History> getHistories() {
        return histories;
    }
}


