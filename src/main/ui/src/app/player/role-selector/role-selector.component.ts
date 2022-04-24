import {Component, OnInit} from '@angular/core';
import {Role} from "../../interfaces/role";
import {RoleService} from "../role.service";
import {TextFormatService} from "../../text-format.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerService} from "../../player.service";

@Component({
  selector: 'app-role-selector',
  templateUrl: './role-selector.component.html',
  styleUrls: ['./role-selector.component.css']
})
export class RoleSelectorComponent implements OnInit {

  //TODO: Should not be able to come here if a role is already selected

  public roles?: Role[];
  public selectedRole = '';
  private readonly id: string;

  constructor(private roleService: RoleService,
              private textFormatService: TextFormatService,
              private playerService: PlayerService,
              private route: ActivatedRoute,
              private router: Router) {
    roleService.getRoles().subscribe(roles => this.roles = roles);
    this.id = route.snapshot.paramMap.get('id')!!;
  }

  ngOnInit(): void {
  }

  formatDescription(text: string) {
    return this.textFormatService.convertFromMarkdownToHtml(text);
  }

  formatName(name: string) {
    return name.replace("_", "-");
  }

  setRole(role: Role) {
    this.playerService.setRole(this.id, role.name).subscribe(
      _ => this.router.navigate(['welcome'], {relativeTo: this.route.parent})
    );
  }
}
