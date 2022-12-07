package ciclo4.proyecto.service;

import ciclo4.proyecto.model.Movie;
import ciclo4.proyecto.model.Score;
import ciclo4.proyecto.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score c){
        if (c.getId() == null){
            return scoreRepository.save(c);
        }else{
            Optional<Score> Scoreaux= scoreRepository.getScore(c.getId());
            if (Scoreaux.isEmpty()){
                return scoreRepository.save(c);
            }else{
                return (c);
            }
        }
    }
    public Score update(Score c){
        if(c.getId()!=null){
            Optional<Score> scoreup= scoreRepository.getScore(c.getId());
            if(!scoreup.isEmpty()){
                if (c.getScore()!=null){
                    scoreup.get().setScore(c.getScore());
                }
                if (c.getState()!=null){
                    scoreup.get().setState(c.getState());
                }
                scoreRepository.save(scoreup.get());
                return scoreup.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean deleteScore(int ScoreId){
        Boolean succes=getScore(ScoreId).map(c ->{
            scoreRepository.delete(c);
            return true;
        }).orElse(false);
        return succes;
    }
}
