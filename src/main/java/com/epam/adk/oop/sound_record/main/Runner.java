package com.epam.adk.oop.sound_record.main;

import com.epam.adk.oop.sound_record.entity.Album;
import com.epam.adk.oop.sound_record.entity.Disk;
import com.epam.adk.oop.sound_record.entity.Track;
import com.epam.adk.oop.sound_record.service.FinderTracksByDuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import static com.epam.adk.oop.sound_record.entity.Album.Builder;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * The class with main method.
 *
 * @author Kaikenov Adilhan.
 */
public class Runner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    /**
     * Application starting point.
     *
     * @param args input arguments array.
     */
    public static void main(String[] args) {

        Disk disk = new Disk();
        FinderTracksByDuration finder = new FinderTracksByDuration();

        Builder builder = new Builder();
        Album album = builder.buildAlbum();

        disk.add(album);

        Collections.sort(album.getComponents(), Album.SORTER_BY_TRACK_GENRE);

        log.info("Sorted disk: {}", disk);

        log.info("Search result: ");
        List<Track> found = finder.find(3, 3, disk);
        Album.printTracks(found);

    }
}
