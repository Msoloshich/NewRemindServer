package com.msolo.NewRemindServer.repos;

import com.msolo.NewRemindServer.domain.Remind;
import org.springframework.data.repository.CrudRepository;

public interface RemindRepo extends CrudRepository<Remind,Long> {
}
