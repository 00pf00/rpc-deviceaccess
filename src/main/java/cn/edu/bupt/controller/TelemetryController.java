package cn.edu.bupt.controller;


import cn.edu.bupt.pojo.kv.BaseTsKvQuery;
import cn.edu.bupt.pojo.kv.TsKvEntry;
import cn.edu.bupt.pojo.kv.TsKvQuery;
import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/data")
public class TelemetryController extends BaseController {

    //通过设备ID和查询内容获取所有历史数据
    @RequestMapping(value="/alldata/{deviceId}",method = RequestMethod.GET)
    public List<TsKvEntry> getAllData(@PathVariable("deviceId") String deviceId,
                                      @RequestParam String key,
                                      @RequestParam String startTs,
                                      @RequestParam String endTs,
                                      @RequestParam int limit
                                      ) throws Exception {
        try{
            List<TsKvQuery> queries = new ArrayList<>();
            TsKvQuery tsKvQuery = new BaseTsKvQuery(key, Long.parseLong(startTs), Long.parseLong(endTs), limit);
            queries.add(tsKvQuery);
            ListenableFuture<List<TsKvEntry>> listListenableFuture = baseTimeseriesService.findAll(toUUID(deviceId),queries);
            List<TsKvEntry> ls = listListenableFuture.get();
            return ls;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //通过设备ID获取所有最新数据
    @RequestMapping(value = "/alllatestdata/{deviceId}", method = RequestMethod.GET)
    public List<TsKvEntry> getlatestData(@PathVariable("deviceId") String deviceId)
    throws Exception{
        try{
            ListenableFuture<List<TsKvEntry>> tskventry = baseTimeseriesService.findAllLatest(toUUID(deviceId));
            List<TsKvEntry> ls = tskventry.get();
            return ls;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    //设备ID和键获取最新
    @RequestMapping(value = "/latestdata/{deviceId}/{keys}", method = RequestMethod.GET)
    public List<TsKvEntry> getlatestData(@PathVariable("deviceId") String deviceId
    ,@PathVariable("keys") Collection<String> keys)
            throws Exception{
        try{
            ListenableFuture<List<TsKvEntry>> tskventry = baseTimeseriesService.findLatest(toUUID(deviceId), keys);
            List<TsKvEntry> ls = tskventry.get();
            return ls;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}