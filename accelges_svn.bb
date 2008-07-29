DESCRIPTION = "Openmoko Accelerometer-based Gestures"
SECTION = "openmoko/utilities"

PN = "accelges"
PV = "0.1.0+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://accelges.googlecode.com/svn;module=trunk;proto=https"

S = "${WORKDIR}/trunk"

inherit autotools update-rc.d

do_install_append() {
	install -d ${D}${sysconfdir}/accelges/neo2
	install -c -D -m 644 ${S}/config/neo2/* ${D}${sysconfdir}/accelges/neo2
	install -d ${D}${sysconfdir}/accelges/neo3
	install -c -D -m 644 ${S}/config/neo3/* ${D}${sysconfdir}/accelges/neo3
	install -d ${D}${sysconfdir}/accelges/wii
	install -c -D -m 644 ${S}/config/wii/* ${D}${sysconfdir}/accelges/wii
	
	install -d ${D}${sysconfdir}/init.d
	install -c -D -m 755 ${S}/config/init.d/* ${D}${sysconfdir}/init.d/

	update-rc.d -s gesd-neo2 defaults 5
	update-rc.d -s gesl defaults 5
}

FILES_${PN} += ${datadir}
