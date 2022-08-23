package com.lamp.guide.sdk.api.model.objectoperation;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aliyun.oss.model.ResponseHeaderOverrides;
import com.lamp.guide.sdk.api.http.GenericRequest;

import lombok.Data;

@Data
public class GetObjectRequest extends GenericRequest{

    private List<String> matchingETagConstraints = new ArrayList<String>();
    private List<String> nonmatchingEtagConstraints = new ArrayList<String>();
    private Date unmodifiedSinceConstraint;
    private Date modifiedSinceConstraint;
    private String process;

    private long[] range;

    private ResponseHeaderOverrides responseHeaders;

    private URL absoluteUrl;
    private boolean useUrlSignature = false;


    private int trafficLimit;
    
    private File file;

    
    /**
     * Gets the range of the object to download. The range is in the form of
     * {start, end}---start and end is position of the object's content.
     * 
     * @return The range of the object to download.
     */
    public long[] getRange() {
        return range;
    }

    /**
     * Sets the range of the object to download (optional).
     * 
     * @param start
     *            <p>
     *            Start position
     *            </p>
     *            <p>
     *            When the start is non-negative, it means the starting position
     *            to download. When the start is -1, it means the range is
     *            determined by the end only and the end could not be -1. For
     *            example, when start is -1 and end is 100. It means the
     *            download range will be the last 100 bytes.
     *            </p>
     * @param end
     *            <p>
     *            End position
     *            </p>
     *            <p>
     *            When the end is non-negative, it means the ending position to
     *            download. When the end is -1, it means the range is determined
     *            by the start only and the start could not be -1. For example,
     *            when end is -1 and start is 100. It means the download range
     *            will be all exception first 100 bytes.
     *            </p>
     */
    public void setRange(long start, long end) {
        range = new long[] { start, end };
    }
}
