package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Release;

public interface ReleaseService {
    Iterable<Release> listReleases();
}
