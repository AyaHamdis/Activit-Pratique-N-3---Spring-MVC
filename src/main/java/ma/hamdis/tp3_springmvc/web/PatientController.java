package ma.hamdis.tp3_springmvc.web;

import lombok.AllArgsConstructor;
import ma.hamdis.tp3_springmvc.entities.Patient;
import ma.hamdis.tp3_springmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0") int page,
                        @RequestParam(name="size",defaultValue = "3") int size,
                        @RequestParam(name="keyword",defaultValue = "") String keyword){
        //Afficher les patients
        //List<Patient>patientList=patientRepository.findAll();
        //model.addAttribute("listPatients",patientList);
        //return "patients";

        //Faire la pagination

        //Page<Patient> pageList=patientRepository.findAll(PageRequest.of(page,size));

        //Rechercher
        Page<Patient> pageList=patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",pageList.getContent());
        model.addAttribute("pages",new int[pageList.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
