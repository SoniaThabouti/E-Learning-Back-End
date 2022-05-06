package ElearningBack.Service;

import java.util.Optional;

import ElearningBack.model.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import ElearningBack.repository.DocRepository;
import org.springframework.util.StringUtils ;
import java.util.stream.Stream;
@Service
public class DocStorageService {
    @Autowired
    private DocRepository docRepository;

    public Doc store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Doc File = new Doc(fileName, file.getContentType(), file.getBytes());

        return docRepository.save(File);
    }


    public Stream<Doc> getAllDoc() {
        return docRepository.findAll().stream();
    }


    public Optional<Doc> getDoc(Long id) {
        return docRepository.findById(id);
    }
}

