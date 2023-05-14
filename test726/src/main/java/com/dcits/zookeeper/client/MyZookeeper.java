package com.dcits.zookeeper.client;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @Author xuzzb
 * @Create 2023/5/13
 */
public class MyZookeeper {
    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 3888, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

}
