package com.skdjq.service.impl;

import com.skdjq.mapper.MeetingRoomMapper;
import com.skdjq.model.MeetingRoom;
import com.skdjq.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Autowired
    private MeetingRoomMapper meetingRoomMapper;

    public List<MeetingRoom> getAllMr() {
        return meetingRoomMapper.getAllMr();
    }

    public MeetingRoom getMrById(Integer roomid) {
        return meetingRoomMapper.getMrById(roomid);
    }

    public Integer updateroom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateroom(meetingRoom);
    }

    public Integer doAddMr(MeetingRoom meetingRoom) {
        return meetingRoomMapper.doAddMr(meetingRoom);
    }
}
