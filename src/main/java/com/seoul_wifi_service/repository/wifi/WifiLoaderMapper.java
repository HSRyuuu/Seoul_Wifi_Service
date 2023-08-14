package com.seoul_wifi_service.repository.wifi;

import com.seoul_wifi_service.dto.WifiDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WifiLoaderMapper {
    void loadList(List<WifiDTO> list);
}
