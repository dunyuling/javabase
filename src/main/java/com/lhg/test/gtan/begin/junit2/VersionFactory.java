package com.lhg.test.gtan.begin.junit2;

public class VersionFactory {
    public static Category judgeKind(String str) {
        if(str.contains("-") && !str.contains("SNAPSHOT")) {
            return Category.DASH;
        } else if(str.contains("SNAPSHOT")) {
            return Category.SNAPSHOT;
        } else if(str.contains("RC")) {
            return Category.RC;
        } else {
            return Category.NUMBER;
        }
    }

    public static BaseVersion createVersion(String version) {
	BaseVersion baseVersion = null;
	switch(judgeKind(version)) {
	case NUMBER:
	    baseVersion = new NumberVersion(version);
	    break;
	case DASH:
	    baseVersion = new DashVersion(version);
	    break;
	case SNAPSHOT:
	    baseVersion = new SnapshotVersion(version);
	    break;
	case RC:
	    baseVersion = new RcVersion(version);
	    break;
	}
	return baseVersion;
    }
}

