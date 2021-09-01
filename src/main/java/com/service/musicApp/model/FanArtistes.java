package com.service.musicApp.model;


import java.util.List;

public class FanArtistes {
   public Long fanId;
   public List<Artiste> artistes;

    public Long getFanId() {
        return fanId;
    }

    public void setFanId(Long fanId) {
        this.fanId = fanId;
    }

    public List<Artiste> getArtist() {
        return artistes;
    }

    public void setArtist(List<Artiste> artist) {
        this.artistes = artist;
    }

    @Override
    public String toString() {
        return "FanArtistes{" +
                "fanId=" + fanId +
                ", artist=" + artistes +
                '}';
    }
}
