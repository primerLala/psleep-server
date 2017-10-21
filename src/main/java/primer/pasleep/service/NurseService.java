package primer.pasleep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primer.pasleep.mapper.NurseMapper;

/**
 * Created by primer on 17/10/17.
 */
@Service
public class NurseService {
    @Autowired
    private NurseMapper nurseMapper;
}
