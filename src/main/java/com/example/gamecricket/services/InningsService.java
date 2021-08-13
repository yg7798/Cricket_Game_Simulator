package com.example.gamecricket.services;

import com.example.gamecricket.entities.Innings;
import com.example.gamecricket.response_dto.BaseResponse;

import java.util.List;

public interface InningsService {
    List<Innings> getAllInnings();
    BaseResponse createInnings(Innings innings);
    BaseResponse updateInnings(int id, Innings innings);
    Innings getInnings(int id);
    BaseResponse deleteInnings(int id);
    Innings getInningsByMatchNoAndInningsNo(int matchNo,int inningsNo);
}
